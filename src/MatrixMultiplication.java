import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class MatrixMultiplication {


    public static void main(String[] args) {


        int ladoColuna = ;
        int colunaLado = ;
        int limite = ;

        

        try {

            int [][] matrixA = {{1,2,3},{4,5,6}};
            int [][] matrixB = {{7,8},{9,10},{11,12}};

            String server = "https://belmondojr.dev/proc_paralelo.php";

            String jasonmatrixA = convertMatrixToJson(matrixA);
            String jasonmatrixB = convertMatrixToJson(matrixB);

            String encodermatrisA = URLEncoder.encode(jasonmatrixA, "UTF-8");
            String encodermatrisB = URLEncoder.encode(jasonmatrixB, "UTF-8");


            String fullURL = server + "?matrixA="+ encodermatrisA+"&matrixB="+encodermatrisB;

            URL url = new URL(fullURL);
                HttpURLConnection connection =
                        (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine() )!= null ){
                response.append(line);
            }
            reader.close();
            System.out.println("Resposta: "+ response.toString());

        }catch (Exception e){}
    }

    // Converte uma matriz em formato JSON
    public static String convertMatrixToJson(int[][] matrix) {
        StringBuilder json = new StringBuilder("[");
        for (int i = 0; i < matrix.length; i++) {
            json.append("[");
            for (int j = 0; j < matrix[i].length; j++) {
                json.append(matrix[i][j]);
                if (j < matrix[i].length - 1) {
                    json.append(",");
                }
            }
            json.append("]");
            if (i < matrix.length - 1) {
                json.append(",");
            }
        }
        json.append("]");
        return json.toString();
    }

    public int [][] montamatrix (int linha, int coluna,int limite){


        return matrix;
    }
}