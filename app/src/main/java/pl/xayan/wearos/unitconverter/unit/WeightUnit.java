package pl.xayan.wearos.unitconverter.unit;

public enum WeightUnit implements Unit {
    MICROGRAM("Microgram", "μg", 1e-6),
    MILLIGRAM("Milligram", "mg", 1e-3),
    GRAM("Gram", "g", 1),
    KILOGRAM("Kilogram", "kg", 1e3),
    TONNE("Tonne", "t", 1e6);

    public final String name;
    public final String abbreviation;
    public final Number ratio;

    WeightUnit(String name, String abbreviation, Number ratio) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.ratio = ratio;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAbbreviation() {
        return abbreviation;
    }
}
