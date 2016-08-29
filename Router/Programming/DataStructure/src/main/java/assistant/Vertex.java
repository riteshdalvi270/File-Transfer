package assistant;

public class Vertex {
    String value;
    Vertex parent;
    String color;

    public Vertex(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
    }

    public void setParent(final Vertex parent) {
        this.parent = parent;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Vertex getParent() {
        return parent;
    }

    public String getColor() {
        return color;
    }
}
