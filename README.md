# HibernateAnnotations
Hibernate application in which demonstrates the usage of annotations using Inner Joins, SessionFactory, Hibernate Cascade Functionality, etc.

# When to use annotations?
> Use annotations to provide metadata configuration along with the Java code. That way the code is easy to understand. Annotations are less powerful than XML configuration. XML also gives you the ability to change the configuration without building the project. So use annotations only for table and column mappings, not for frequently changing stuff like database connection and other properties. Annotations are preconfigured with sensible default values, which reduce the amount of coding required, e.g. class name defaults to table name and field names defaults to column names.

# Quick reference on annotations used
| Annotation | Modifier | Description |
| ------ | ------ | ------ |
| @Entity |  |Marks a class as a Hibernate Entity (Mapped class) |
| @Table | Name | Maps this class with a database table specified by name modifier. If name is not supplied it maps the class with a table having same name as the class |
|@Id | | Marks this class field as a primary key column.
|@GeneratedValue | | Instructs database to generate a value for this field automatically.
|@Column | Name | Maps this field with table column specified by name and uses the field name if name modifier is absent.
|@ManyToMany | Cascade | Marks this field as the owning side of the many-to-many relationship and cascade modifier specifies which operations should cascade to the inverse side of relationship.
|@ManyToMany | mappedBy | This modifier holds the field which specifies the inverse side of the relationship.
|@JoinTable | Name | For holding this many-to-many relationship, maps this field with an intermediary database join table specified by name modifier.
|@JoinTable | joinColumns | Identifies the owning side of columns which are necessary to identify a unique owning object.
|@JoinTable | inverseJoinColumns | Identifies the inverse (target) side of columns which are necessary to identify a unique target object.
|@JoinColumn | Name | Maps a join column specified by the name identifier to the relationship table specified by @JoinTable.

