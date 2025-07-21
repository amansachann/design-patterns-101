package com.codewithaman.CreationalPatterns.BuilderPattern.WithBuilderPattern;

public class House {
    private String foundation;
    private String structure;
    private String roof;
    private boolean hasGarage;
    private boolean hasBasement;
    private boolean hasSwimmingPool;
    private boolean hasGarden;

    // Step-1: Create an all args constructor for parent class
    public House(String foundation, String structure, String roof, boolean hasGarage, boolean hasBasement, boolean hasSwimmingPool, boolean hasGarden) {
        this.foundation = foundation;
        this.structure = structure;
        this.roof = roof;
        this.hasGarage = hasGarage;
        this.hasBasement = hasBasement;
        this.hasSwimmingPool = hasSwimmingPool;
        this.hasGarden = hasGarden;
    }

    // Step-2: Create a public static builder class with same fields
    public static class Builder {
        private String foundation;
        private String structure;
        private String roof;
        private boolean hasGarage;
        private boolean hasBasement;
        private boolean hasSwimmingPool;
        private boolean hasGarden;

        // Step-3: Add constructor for mandatory fields
        public Builder(String foundation, String structure, String roof) {
            this.foundation = foundation;
            this.structure = structure;
            this.roof = roof;
        }

        // Step-4: Create builder methods for remaining fields which should return the builder object
        // Optional Parameters
        public Builder setHasGarage(boolean hasGarage) {
            this.hasGarage = hasGarage;
            return this;
        }

        public Builder setHasBasement(boolean hasBasement) {
            this.hasBasement = hasBasement;
            return this;
        }

        public Builder setHasSwimmingPool(boolean hasSwimmingPool) {
            this.hasSwimmingPool = hasSwimmingPool;
            return this;
        }

        public Builder setHasGarden(boolean hasGarden) {
            this.hasGarden = hasGarden;
            return this;
        }

        // Step-5: Create a build method which calls the all args constructor of
        // parent class and return parent class object
        public House build() {
            return new House(foundation, structure, roof, hasGarage, hasBasement, hasSwimmingPool, hasGarden);
        }
    }

    @Override
    public String toString() {
        return "House{" +
                "foundation='" + foundation + '\'' +
                ", structure='" + structure + '\'' +
                ", roof='" + roof + '\'' +
                ", hasGarage=" + hasGarage +
                ", hasBasement=" + hasBasement +
                ", hasSwimmingPool=" + hasSwimmingPool +
                ", hasGarden=" + hasGarden +
                '}';
    }
}
