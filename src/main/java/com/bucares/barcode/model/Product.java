package com.bucares.barcode.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @JsonIgnore
  private Long id;

  @Column(unique = true, nullable = false)
  private String barcode;

  @Column(nullable = false)
  private String name;

  @Column(columnDefinition = "TEXT")
  private String ingredients;

  @Column(columnDefinition = "TEXT")
  private String categories;

  @Column
  private String quantity;

  @Column
  private String picture;
}
