class ClassDefinition {
  private List<Attribute> attributes = new ArrayList<>();
  private String className;

  public ModelClass(String className) {
    this.className = className;
  }

  public void addAttr(String type, String attrName) {
    Attribute att = new Attribute(type, attrName);
    attributes.add(att);
  }

  public String getClassName() {
    return className;
  }

  public List<Attribute> getAttributes() {
    return attributes;
  }
}
