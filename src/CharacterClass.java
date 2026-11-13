public abstract class CharacterClass {
    protected final Race race;
    protected CharacterClass(Race race) { this.race = race; }
    public Race getRace() { return race; }
    public abstract String getName();
    public String getSubclassName() { return "None"; }
    public abstract String getDescription();
    public String getRaceInfo() {
        return race.getName();
    }
}
