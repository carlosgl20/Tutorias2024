package com.spring.tutoriasEDU.enmarca;

import com.spring.tutoriasEDU.actividad.Actividad;
import com.spring.tutoriasEDU.planes.Plan;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

@Entity
public class Enmarca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String fecha;

	@ManyToOne
	@JoinColumn(name = "actividad_id")
	Actividad actividad;

	@ManyToOne
	@JoinColumn(name = "plan_id")
	Plan plan;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Actividad getActividad() {
		return actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

}
