package com.trioptimum.shodan.helper;

import com.trioptimum.shodan.common.internal.Binding;
import com.trioptimum.shodan.common.internal.Call;
import com.trioptimum.shodan.common.internal.CallablePoint;
import com.trioptimum.shodan.common.internal.StrongCallablePoint;
import com.trioptimum.shodan.lookup.api.Key;

import java.lang.reflect.Method;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 * User: Turtles
 * Date: 11.12.12
 * Time: 21:32
 * To change this template use File | Settings | File Templates.
 */
public class TestBindings {

    public static TestBindingBuilder from(Method target) {
        return from(new StrongCallablePoint(target, null));
    }

    public static TestBindingBuilder from(CallablePoint target) {
        return new TestBindingBuilder(target);
    }

    public static class TestBindingBuilder {

        CallablePoint target;

        TestBindingBuilder(CallablePoint target) {
            this.target = target;
        }

        public Binding to(Method destination) {
            return to(new StrongCallablePoint(destination, null));
        }

        public Binding to(CallablePoint newTarget) {
            return new Binding(new Key(new Call(target, Collections.emptyList(), null)), newTarget);
        }
    }
}
