package Tests;
import org.testng.TestNG;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class RunTestsMultipleTimesTest {
    @Test
    public void runTestsMultipleTimes() {
        for(int i=0;i<3;i++)
        {
            List<String> suites = new ArrayList<>();
            suites.add("C:\\Users\\Aleks.Aleksovski\\IdeaProjects\\PageObjectModelProject\\testing.xml"); //path of .xml file to be run-provide complete path

            TestNG tng = new TestNG();
            tng.setTestSuites(suites);

            tng.run(); //run test suite
        }
    }
}