package org.perscholas.mavenlabs.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name ="USER")
public class User {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	 int id;
	@NonNull
	String fullname;
	@NonNull
    String email;
	@NonNull
    String password; 
	@NonNull
     int age;
	@NonNull
	 double salary;
	@NonNull
	 String city;

}

