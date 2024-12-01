package code_clone;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class CosineSimilarity {

    private final List<double[]> similarityResults;
    public CosineSimilarity(){
        this.similarityResults = new ArrayList<>();
    }


    public List<double[]>
        calculatesSimilarity(List<String>
          projectFileNames1, List<String>
          projectFileNames2,
        List<double[]> vectors1, List<double[]>vectors2){
        for (int i = 0; i < ProjectFileNames1.size(); i++) {
            double[] similarityRow = new double[projectFileNames2.size()];

            for (int j = 0; j < CloneCheck.ProjectFileName2.size(); j++) {
                similarity = cosineSimilarity(TfIdfCalculate.tfidfvectorProject1.get(i), TfIdfCalculate.tfidfvectorProject2.get(j));
                BigDecimal bd = new BigDecimal(similarity).setScale(2, RoundingMode.HALF_UP);
                double getSimilar = bd.doubleValue();
                System.out.println(CloneCheck.ProjectFileName1.get(i) + " vs " + CloneCheck.ProjectFileName2.get(j) + " " + getSimilar + "%");
                similar[count] = similarity;


                count++;
            }
            similarArray.add(similar);
        }

    }

    public double cosineSimilarity(double[] project1, double[] project2) {
        double dotproduct = 0;
        double project1magnitude = 0;
        double project2magnitude = 0;
        double cosinesimilarity = 0;
        for (int i = 0; i < project2.length; i++) {
            dotproduct += project1[i] * project2[i];
            project1magnitude += Math.pow(project1[i], 2);
            project2magnitude += Math.pow(project2[i], 2);

        }
        project1magnitude = Math.sqrt(project1magnitude);
        project2magnitude = Math.sqrt(project2magnitude);

        cosinesimilarity = dotproduct / (project1magnitude * project2magnitude) * 100;
        if (Double.isNaN(cosinesimilarity)) {
            cosinesimilarity = 0.0;
        }
        return cosinesimilarity;

    }



}
