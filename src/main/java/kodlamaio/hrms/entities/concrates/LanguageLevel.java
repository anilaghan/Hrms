package kodlamaio.hrms.entities.concrates;

public enum LanguageLevel {
   BEGINNER (1),PRE_INTERMEDIATE(2),INTERMEDIATE(3),UPPER_INTERMEDIATE(4),ADVANCE(5);
    private int value;
   private LanguageLevel(int value){
       this.value=value;
   }
}
