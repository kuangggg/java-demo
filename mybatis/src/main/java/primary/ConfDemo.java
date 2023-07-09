package primary;

import org.apache.ibatis.builder.xml.XMLConfigBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import java.io.IOException;
import java.io.Reader;

public class ConfDemo {

    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";

        Reader resourceAsReader = Resources.getResourceAsReader(resource);

        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(resourceAsReader);

        Configuration parse = xmlConfigBuilder.parse();

        System.out.println(parse);

    }
}
