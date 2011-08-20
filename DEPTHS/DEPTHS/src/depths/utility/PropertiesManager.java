package depths.utility;

import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;
import depths.coordinator.Tutor;

public class PropertiesManager {

        private String domainModuleURI;
        private String lomURI;
        private String rules;
        private String svg_uri;
        private Tutor tutor;
       public PropertiesManager(Tutor tutRef){
         tutor=tutRef;

           setParams();
           printParams();
       }
       private void setParams(){
           try {

               InputStream is = getClass().getResourceAsStream("configuration.properties");

               Properties props = new Properties();
               props.load( is );
               is.close();

               loadURIs(props);

            } catch (IOException e) {
                  System.out.println(e.getStackTrace().toString());
            }

       }
       public void printParams(){

       }
       private void loadURIs(Properties props){

           domainModuleURI=props.getProperty("domain_module_uri");

           lomURI=props.getProperty("lom_uri");
           rules=props.getProperty("rules");
           svg_uri=props.getProperty("svg_uri");

           tutor.setDomainModuleURI(domainModuleURI);

           tutor.setLomURI(lomURI);
           tutor.setRulesURI(rules);
           tutor.setSvgURI(svg_uri);

       }





}



