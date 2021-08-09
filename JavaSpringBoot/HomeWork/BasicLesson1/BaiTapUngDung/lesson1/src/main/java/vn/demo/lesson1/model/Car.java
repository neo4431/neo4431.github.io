package vn.demo.lesson1.model;

public class Car {
    private int id;
    private String name;
    private String manufacturer;
    private int price;
    private String photo;
    

    // Source Action
    public Car(int id, String name, String manufacturer, int price, String photo) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getManufacturer() {
        return manufacturer;
    }


    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }


    public int getPrice() {
        return price;
    }


    public void setPrice(int price) {
        this.price = price;
    }


    public String getPhoto() {
        return photo;
    }


    public void setPhoto(String photo) {
        this.photo = photo;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((photo == null) ? 0 : photo.hashCode());
        result = prime * result + price;
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Car other = (Car) obj;
        if (id != other.id)
            return false;
        if (manufacturer == null) {
            if (other.manufacturer != null)
                return false;
        } else if (!manufacturer.equals(other.manufacturer))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (photo == null) {
            if (other.photo != null)
                return false;
        } else if (!photo.equals(other.photo))
            return false;
        if (price != other.price)
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "Car [id=" + id + ", manufacturer=" + manufacturer + ", name=" + name + ", photo=" + photo + ", price="
                + price + "]";
    }
    
}
