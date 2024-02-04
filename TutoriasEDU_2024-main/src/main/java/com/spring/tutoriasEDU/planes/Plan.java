package com.spring.tutoriasEDU.planes;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.spring.tutoriasEDU.Curso.Curso;
import com.spring.tutoriasEDU.actividad.Actividad;
import com.spring.tutoriasEDU.enmarca.Enmarca;
import com.spring.tutoriasEDU.tutores.Tutor;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Plan {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String nombre;
	
	
	@OneToOne(targetEntity=Tutor.class,mappedBy="plan")
	private Tutor tutor;
	
	@ManyToOne(targetEntity = Curso.class)
	@JoinColumn(name="FK_CURSO")
	@JsonBackReference	
	private Curso curso;
	
	@OneToMany(mappedBy="plan")
	private Set<Enmarca> enmarcados;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Enmarca",
            joinColumns = @JoinColumn(name = "plan_id"),
            inverseJoinColumns = @JoinColumn(name = "actividad_id"))
    private Set<Actividad> actividades = new HashSet<Actividad>();
	
	
	public Set<Actividad> getActividades() {
		return actividades;
	}

	public void setActividades(Set<Actividad> actividades) {
		this.actividades = actividades;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	@Override
	public String toString() {
		return "Plan [id=" + id + ", nombre=" + nombre + ", tutor=" + tutor + ", curso=" + curso + "]";
	}
	
	

	
	
	
	
	
	
	
}
