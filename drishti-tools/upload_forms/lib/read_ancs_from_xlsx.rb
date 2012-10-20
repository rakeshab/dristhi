require 'roo'
require 'csv'
require 'erb'
require 'guid'
require './lib/care_import_row.rb'
require './lib/commcare.rb'
require './lib/village.rb'

class ANCs
  def initialize xlsx_filename
    @ancs = []

    read_from xlsx_filename
  end

  def ancs
    @ancs.collect { |anc| anc.to_hash }
  end

  def ancs_grouped_per_couple
    ancs.group_by { |anc| [anc['a.Village Code'].village.downcase, anc['a.Wife Name'].downcase, anc['a.Husband Name'].downcase] }
  end

  private
  def read_from xlsx_filename
    filename = "#{Random.rand(9999999)}_ANC_register.csv"

    begin
      spreadsheet = Excelx.new xlsx_filename, nil, :ignore
      spreadsheet.to_csv filename, "ANC register"


      CSV.foreach(filename, {:headers => true}) do |csv_row|
        anc = Row.new csv_row

        anc.convert_value "Year", :empty => "2012"
        anc.convert_value "a.Village Name", :empty => "munjanahalli"
        anc.convert_value "a.Wife Name", :empty => "Wife Name"
        anc.convert_value "a.Wife Age", :empty => "20"
        anc.convert_value "a.Husband Name", :empty => "Husband Name"
        anc.convert_value "Sno", :empty => "O/A 111111"
        anc.convert_to_date "a.Registration date", :empty => Date.today.to_s
        anc.convert_value "a.House Number", :empty => "111111"
        anc.convert_value "New EC No", :empty => "111111"
        anc.convert_value "Old  EC No", :empty => "111111"
        anc.convert_value "a.Thayi Card Number", :empty => "1234567"
        anc.convert_value "Husband Age", :empty => "20"
        anc.convert_value "Address", :empty => "Address unknown"
        anc.convert_value "Education", :empty => "Unknown"
        anc.convert_value "Occupation", :empty => "Unknown"
        anc.convert_value "No of Living Male Children", :empty => "0"
        anc.convert_value "No of Living Female Children", :empty => "0"
        anc.convert_value "Gravida", :empty => "0"
        anc.convert_value "Number of parity(P)", :empty => "0"
        anc.convert_value "Number of livebirth(L)", :empty => "0"
        anc.convert_value "Number of abortion(A)", :empty => "0"
        anc.convert_value "Duration of Pregnancy in Weeks", :empty => "36"
        anc.convert_to_date "LMP", :empty => Date.today.to_s
        anc.convert_to_date "EDD", :empty => Date.today.to_s
        anc.convert_value "Height", :empty => "150"
        anc.convert_value "Out of area", :empty => "Yes"
        anc.convert_value "No of ANM Visits", :empty => "0"
        anc.convert_to_date "Date of Delivery", :empty => Date.today.to_s
        anc.convert_value "Outcomes", :empty => "Unknown"
        anc.convert_value "Child Weight at Delivery time", :empty => "2.5"
        anc.convert_value "Place of Delivery", :empty => "Unknown"
        anc.convert_to_date "Date of Left the Place", :empty => Date.today.to_s
        anc.convert_value "Religion", :default => "r_others"

        anc.convert_value "HRP",
                          "No" => "no",
                          "Yes" => "yes",
                          :empty => "no",
                          :default => "no"

        anc.convert_value "Caste",
                          "SC" => "sc",
                          "ST" => "st",
                          :empty => "c_others",
                          :default => "c_others"

        anc.convert_value "BPL",
                          "Yes" => "bpl",
                          "No" => "apl",
                          :empty => "apl",
                          :default => "apl"

        anc.convert_value "a.Village Code", Village.code_to_village_hash

        anc.add_field "Case ID", Guid.new.to_s
        anc.add_field "Instance ID", Guid.new.to_s

        anc.add_field "Three or More Live Births", anc['Number of livebirth(L)'].to_i >= 3
        anc.add_field "Three or More Abortions", anc['Number of abortion(A)'].to_i >= 3

        @ancs << anc
      end
    ensure
      FileUtils.rm_f filename
    end
  end
end
