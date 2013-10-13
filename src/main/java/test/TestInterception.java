package test;

import com.trioptimum.shodan.common.internal.ParameterizedCalling;
import com.trioptimum.shodan.intercept.internal.DispatchContext;
import com.trioptimum.shodan.intercept.service.Interception;

/**
 * Created by trtles on 10/7/13.
 */
public class TestInterception implements Interception {

    public Object intercept(DispatchContext context, ParameterizedCalling callablePoint) throws Exception {
        System.out.println("intercept before");
        return callablePoint.call("value changed");
    }
}
