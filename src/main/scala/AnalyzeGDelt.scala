import org.apache.spark.sql.SparkSession
import spark.implicits._
import org.apache.spark.sql.types.{StructType, StructField, DataTypes}

object AnalyzeGDelt {
	def main(args: Array[String]) {
		val spark = SparkSession
			.builder
			.appName("Analyze GDelt")
			.getOrCreate()

		//Define types for columns in dataset
		val GLOBALEVENTID = StructField("GLOBALEVENTID", DataTypes.IntegerType)
		val SQLDATE = StructField("SQLDATE", DataTypes.IntegerType)
		val MonthYear = StructField("MonthYear", DataTypes.IntegerType)
		val Year = StructField("Year", DataTypes.IntegerType)
		val FractionDate = StructField("FractionDate", DataTypes.FloatType)
		val Actor1Code = StructField("Actor1Code", DataTypes.StringType)
		val Actor1Name = StructField("Actor1Name", DataTypes.StringType)
		val Actor1CountryCode = StructField("Actor1CountryCode", DataTypes.StringType)
		val Actor1KnownGroupCode = StructField("Actor1KnownGroupCode", DataTypes.StringType)
		val Actor1EthnicCode = StructField("Actor1EthnicCode", DataTypes.StringType)
		val Actor1Religion1Code = StructField("Actor1Religion1Code", DataTypes.StringType)
		val Actor1Religion2Code = StructField("Actor1Religion2Code", DataTypes.StringType)
		val Actor1Type1Code = StructField("Actor1Type1Code", DataTypes.StringType)
		val Actor1Type2Code = StructField("Actor1Type2Code", DataTypes.StringType)
		val Actor1Type3Code = StructField("Actor1Type3Code", DataTypes.StringType)
		val Actor2Code = StructField("Actor2Code", DataTypes.StringType)
		val Actor2Name = StructField("Actor2Name", DataTypes.StringType)
		val Actor2CountryCode = StructField("Actor2CountryCode", DataTypes.StringType)
		val Actor2KnownGroupCode = StructField("Actor2KnownGroupCode", DataTypes.StringType)
		val Actor2EthnicCode = StructField("Actor2EthnicCode", DataTypes.StringType)
		val Actor2Religion1Code = StructField("Actor2Religion1Code", DataTypes.StringType)
		val Actor2Religion2Code = StructField("Actor2Religion2Code", DataTypes.StringType)
		val Actor2Type1Code = StructField("Actor2Type1Code", DataTypes.StringType)
		val Actor2Type2Code = StructField("Actor2Type2Code", DataTypes.StringType)
		val Actor2Type3Code = StructField("Actor2Type3Code", DataTypes.StringType)
		val IsRootEvent = StructField("IsRootEvent", DataTypes.IntegerType)
		val EventCode = StructField("EventCode", DataTypes.StringType)
		val EventBaseCode = StructField("EventBaseCode", DataTypes.StringType)
		val EventRootCode = StructField("EventRootCode", DataTypes.StringType)
		val QuadClass = StructField("QuadClass", DataTypes.IntegerType)
		val GoldsteinScale = StructField("GoldsteinScale", DataTypes.FloatType)
		val NumMentions = StructField("NumMentions", DataTypes.IntegerType)
		val NumSources = StructField("NumSources", DataTypes.IntegerType)
		val NumArticles = StructField("NumArticles", DataTypes.IntegerType)
		val AvgTone = StructField("AvgTone", DataTypes.FloatType)
		val Actor1Geo_Type = StructField("Actor1Geo_Type", DataTypes.IntegerType)
		val Actor1Geo_FullName = StructField("Actor1Geo_FullName", DataTypes.StringType)
		val Actor1Geo_CountryCode = StructField("Actor1Geo_CountryCode", DataTypes.StringType)
		val Actor1Geo_ADM1Code = StructField("Actor1Geo_ADM1Code", DataTypes.StringType)
		val Actor1Geo_ADM2Code = StructField("Actor1Geo_ADM2Code", DataTypes.StringType)
		val Actor1Geo_Lat = StructField("Actor1Geo_Lat", DataTypes.FloatType)
		val Actor1Geo_Long = StructField("Actor1Geo_Long", DataTypes.FloatType)
		val Actor1Geo_FeatureID = StructField("Actor1Geo_FeatureID", DataTypes.StringType)
		val Actor2Geo_Type = StructField("Actor2Geo_Type", DataTypes.IntegerType)
		val Actor2Geo_FullName = StructField("Actor2Geo_FullName", DataTypes.StringType)
		val Actor2Geo_CountryCode = StructField("Actor2Geo_CountryCode", DataTypes.StringType)
		val Actor2Geo_ADM1Code = StructField("Actor2Geo_ADM1Code", DataTypes.StringType)
		val Actor2Geo_ADM2Code = StructField("Actor2Geo_ADM2Code", DataTypes.StringType)
		val Actor2Geo_Lat = StructField("Actor2Geo_Lat", DataTypes.FloatType)
		val Actor2Geo_Long = StructField("Actor2Geo_Long", DataTypes.FloatType)
		val Actor2Geo_FeatureID = StructField("Actor2Geo_FeatureID", DataTypes.StringType)
		val ActionGeo_Type = StructField("ActionGeo_Type", DataTypes.IntegerType)
		val ActionGeo_FullName = StructField("ActionGeo_FullName", DataTypes.StringType)
		val ActionGeo_CountryCode = StructField("ActionGeo_CountryCode", DataTypes.StringType)
		val ActionGeo_ADM1Code = StructField("ActionGeo_ADM1Code", DataTypes.StringType)
		val ActionGeo_ADM2Code = StructField("ActionGeo_ADM2Code", DataTypes.StringType)
		val ActionGeo_Lat = StructField("ActionGeo_Lat", DataTypes.FloatType)
		val ActionGeo_Long = StructField("ActionGeo_Long", DataTypes.FloatType)
		val ActionGeo_FeatureID = StructField("ActionGeo_FeatureID", DataTypes.StringType)
		val DATEADDED = StructField("DATEADDED", DataTypes.LongType)
		val SOURCEURL = StructField("SOURCEURL", DataTypes.StringType)

		//define fields for schema
		val fields = Array(GLOBALEVENTID, SQLDATE, MonthYear, Year, FractionDate, Actor1Code, Actor1Name, Actor1CountryCode, Actor1KnownGroupCode, Actor1EthnicCode, Actor1Religion1Code, Actor1Religion2Code, Actor1Type1Code, Actor1Type2Code, Actor1Type3Code, Actor2Code, Actor2Name, Actor2CountryCode, Actor2KnownGroupCode, Actor2EthnicCode, Actor2Religion1Code, Actor2Religion2Code, Actor2Type1Code, Actor2Type2Code, Actor2Type3Code, IsRootEvent, EventCode, EventBaseCode, EventRootCode, QuadClass, GoldsteinScale, NumMentions, NumSources, NumArticles, AvgTone, Actor1Geo_Type, Actor1Geo_FullName, Actor1Geo_CountryCode, Actor1Geo_ADM1Code, Actor1Geo_ADM2Code, Actor1Geo_Lat, Actor1Geo_Long, Actor1Geo_FeatureID, Actor2Geo_Type, Actor2Geo_FullName, Actor2Geo_CountryCode, Actor2Geo_ADM1Code, Actor2Geo_ADM2Code, Actor2Geo_Lat, Actor2Geo_Long, Actor2Geo_FeatureID, ActionGeo_Type, ActionGeo_FullName, ActionGeo_CountryCode, ActionGeo_ADM1Code, ActionGeo_ADM2Code, ActionGeo_Lat, ActionGeo_Long, ActionGeo_FeatureID, DATEADDED, SOURCEURL)
		
		//define schema
		val schema = StructType(fields)

		//read dataset into dataframe with defined schema
		val df = spark.read.schema(schema).option("header", true).csv("input/event0.CSV")

		//show the schema
		df.printSchema

		//define scala case class
		case class GDeltEntry(GLOBALEVENTID: Int, SQLDATE: Int, MonthYear: Int, Year: Int, FractionDate: Option[Float], Actor1Code: String, Actor1Name: String, Actor1CountryCode: String, Actor1KnownGroupCode: String, Actor1EthnicCode: String, Actor1Religion1Code: String, Actor1Religion2Code: String, Actor1Type1Code: String, Actor1Type2Code: String, Actor1Type3Code: String, Actor2Code: String, Actor2Name: String, Actor2CountryCode: String, Actor2KnownGroupCode: String, Actor2EthnicCode: String, Actor2Religion1Code: String, Actor2Religion2Code: String, Actor2Type1Code: String, Actor2Type2Code: String, Actor2Type3Code: String, IsRootEvent: Int, EventCode: String, EventBaseCode: String, EventRootCode: String, QuadClass: Int, GoldsteinScale: Option[Float], NumMentions: Int, NumSources: Int, NumArticles: Int, AvgTone: Option[Float], Actor1Geo_Type: Int, Actor1Geo_FullName: String, Actor1Geo_CountryCode: String, Actor1Geo_ADM1Code: String, Actor1Geo_ADM2Code: String, Actor1Geo_Lat: Option[Float], Actor1Geo_Long: Option[Float], Actor1Geo_FeatureID: String, Actor2Geo_Type: Int, Actor2Geo_FullName: String, Actor2Geo_CountryCode: String, Actor2Geo_ADM1Code: String, Actor2Geo_ADM2Code: String, Actor2Geo_Lat: Option[Float], Actor2Geo_Long: Option[Float], Actor2Geo_FeatureID: String, ActionGeo_Type: Int, ActionGeo_FullName: String, ActionGeo_CountryCode: String, ActionGeo_ADM1Code: String, ActionGeo_ADM2Code: String, ActionGeo_Lat: Option[Float], ActionGeo_Long: Option[Float], ActionGeo_FeatureID: String, DATEADDED: Long, SOURCEURL: String)
	
		//transform dataframe into dataset as defined by the case class
		val ds = df.as[GDeltEntry]

		//filter out non '2016' entries 
		val year2016 = ds.filter($"Year" === 2016)

		//sort by SQLDATE and write output to CSV
		year2016.orderBy($"SQLDATE").write.csv("output/output.CSV")
	}
}