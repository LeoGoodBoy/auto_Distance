package otodistances;
import java.util.ArrayList;

/* @author robertusadi */
public class MyProgram {
    public static void main(String[] args) {
        DBImplementation db = new DBImplementation();
        Calculation calc = new Calculation();
        ArrayList<Location> ptkList = db.getPTKLocation();
        ArrayList<Location> sekList = db.getSekolahLocation();
        
        int apiIndex = 0;
        int no=1;
        System.out.println("===*** API Key: "+calc.getApiKey(apiIndex)+" ***===");
        for(int i=0; i<ptkList.size(); i++){
            for(int j=0; j<sekList.size(); j++){            
                
                double distByGoogle = calc.getDistanceGoogleAPI(ptkList.get(i), sekList.get(j), calc.getApiKey(apiIndex));
                
                Distance dist = new Distance();
                dist.setOrigin(ptkList.get(i));
                dist.setDestination(sekList.get(j));
                dist.setDistance(distByGoogle);
                
                db.insertDistanceToDB(dist);
                
                System.out.println("["+no+"]["+
                        dist.getOrigin().getId()+" "+
                        dist.getOrigin().getName()+"]-->["+
                        dist.getDestination().getId()+" "+
                        dist.getDestination().getName()+"] << "+
                        distByGoogle +" m >>");
                
                no++;
            }
            
            if((i+1)%4==0){
                apiIndex++;
                System.out.println("===*** API Key: "+calc.getApiKey(apiIndex)+" ***===");                
            }
            
        }
        
    }
}
