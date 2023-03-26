package com.redis1.rediscache.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Invoice implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1790491026249083401L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer invId;
	private String invName;
	private Double invAmount;

}
