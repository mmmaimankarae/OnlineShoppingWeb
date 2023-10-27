package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Shoppingcart;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2566-10-25T23:20:02")
@StaticMetamodel(Products.class)
public class Products_ { 

    public static volatile SingularAttribute<Products, String> movie;
    public static volatile SingularAttribute<Products, Integer> price;
    public static volatile SingularAttribute<Products, String> rating;
    public static volatile CollectionAttribute<Products, Shoppingcart> shoppingcartCollection;
    public static volatile SingularAttribute<Products, Integer> id;
    public static volatile SingularAttribute<Products, String> yearcreate;

}