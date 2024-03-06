package model;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="juegos")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Juego {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	
	@Column(name = "nombre")
	@NotEmpty(message = "El nombre no puede estar vacio")
	private String nombre;

	@Column(name = "fechaPublicacion")
	@Max(value = 2024)
	@Positive
	private int fechaPublicacion;

	@Column(name = "editor")
	@NotEmpty(message = "El editor no puede estar vacio")
	private String editor;

	@Column(name = "plataforma")
	@Enumerated(EnumType.STRING)
	@NotEmpty(message = "La plataforma no puede estar vacia")
	private Platform plataforma;

	@Column(name = "genero")
	@Enumerated(EnumType.STRING)
	@NotEmpty(message = "El genero no puede estar vacio")
	private Genre genero;

	@Column(name = "ventas")
	@NotEmpty(message = "Las ventas no pueden estar vacias")
	private float ventas;
}
