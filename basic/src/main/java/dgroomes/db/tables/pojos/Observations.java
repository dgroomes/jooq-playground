/*
 * This file is generated by jOOQ.
 */
package dgroomes.db.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Observations implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String observation;

    public Observations() {}

    public Observations(Observations value) {
        this.id = value.id;
        this.observation = value.observation;
    }

    public Observations(
        Integer id,
        String observation
    ) {
        this.id = id;
        this.observation = observation;
    }

    /**
     * Getter for <code>observations.id</code>.
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Setter for <code>observations.id</code>.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter for <code>observations.observation</code>.
     */
    public String getObservation() {
        return this.observation;
    }

    /**
     * Setter for <code>observations.observation</code>.
     */
    public void setObservation(String observation) {
        this.observation = observation;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Observations other = (Observations) obj;
        if (this.id == null) {
            if (other.id != null)
                return false;
        }
        else if (!this.id.equals(other.id))
            return false;
        if (this.observation == null) {
            if (other.observation != null)
                return false;
        }
        else if (!this.observation.equals(other.observation))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.observation == null) ? 0 : this.observation.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Observations (");

        sb.append(id);
        sb.append(", ").append(observation);

        sb.append(")");
        return sb.toString();
    }
}
