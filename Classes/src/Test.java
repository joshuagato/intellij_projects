public class Test {

    public static void main(String[] args){

        Cars holden = new Cars();
        Cars porsche = new Cars();

        System.out.println("Model is: " + porsche.getModel());
        porsche.setModel("911");
        System.out.println("Model is: " + porsche.getModel());
    }
}
