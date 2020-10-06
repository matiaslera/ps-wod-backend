package serializacion

import javax.persistence.Converter
import javax.persistence.AttributeConverter
import java.time.LocalDate
import java.sql.Date
import java.time.LocalDateTime
import java.sql.Timestamp

class ConversionLocalDate {
	
}
//@Converter(autoApply = true)
//class LocalDatePersistenceConverter implements AttributeConverter<LocalDate, Date> {
//	
//	override Date convertToDatabaseColumn(LocalDate localDate) {
//		 return Date.valueOf(localDate);
//	}
//	
//	override LocalDate convertToEntityAttribute(Date date) {
//		return date.toLocalDate();
//	}
//}
//@Converter(autoApply = true)
//class LocalDateTimePersistenceConverter implements AttributeConverter<LocalDateTime, Timestamp> {
//	
//	override Timestamp convertToDatabaseColumn(LocalDateTime entityValue) {
//		return Timestamp.valueOf(entityValue);
//	}
//	
//	override LocalDateTime convertToEntityAttribute(Timestamp databaseValue) {
//		 return databaseValue.toLocalDateTime();
//	}
//}

@SuppressWarnings("UnusedDeclaration")
@Converter(autoApply = true)
class LocalDateConverter implements AttributeConverter<java.time.LocalDate, java.sql.Date> {
	
	override Date convertToDatabaseColumn(LocalDate attribute) {
		return attribute === null ? null : java.sql.Date.valueOf(attribute);
	}
	
	override LocalDate convertToEntityAttribute(Date dbData) {
		return dbData === null ? null : dbData.toLocalDate();
	} 
}

@Converter(autoApply = true)
 class LocalDateTimeConverter implements AttributeConverter<java.time.LocalDateTime, java.sql.Timestamp> {
		
		override Timestamp convertToDatabaseColumn(LocalDateTime attribute) {
			 return attribute === null ? null : java.sql.Timestamp.valueOf(attribute);
		}
		
		override LocalDateTime convertToEntityAttribute(Timestamp dbData) {
			 return dbData === null ? null : dbData.toLocalDateTime();
		}
 
} 