package com.solvd.railway.runner;

import com.solvd.railway.annotation.ClassInfo;
import com.solvd.railway.annotation.MethodInfo;
import com.solvd.railway.generics.Printer;

import java.lang.reflect.Method;

public class MethodRunner {
    private static final Printer<String> logsPrinter = new Printer<>();

    public static void run(Class<?> clazz) {
        logsPrinter.title("Validating labels from " + clazz.getSimpleName());

        if (!clazz.isAnnotationPresent(ClassInfo.class)) {
            logsPrinter.error("FAIL: class " + clazz.getSimpleName() + " has no @ClassInfo label");
        } else {
            ClassInfo classInfo = clazz.getAnnotation(ClassInfo.class);
            if (classInfo.value() == null || classInfo.value().isBlank()) {
                logsPrinter.error("FAIL: class " + clazz.getSimpleName() + " has blank @ClassInfo label");
            } else {
                logsPrinter.info("PASS: class " + clazz.getSimpleName() + " [" + classInfo.value() + "]");
            }
        }

        for (Method method : clazz.getDeclaredMethods()) {
            if (!method.isAnnotationPresent(MethodInfo.class)) {
                logsPrinter.error("FAIL: " + method.getName() + " has no @MethodInfo label");
                continue;
            }

            MethodInfo info = method.getAnnotation(MethodInfo.class);
            if (info.value() == null || info.value().isBlank()) {
                logsPrinter.error("FAIL: " + method.getName() + " has blank @MethodInfo label");
            } else {
                logsPrinter.info("PASS: " + method.getName() + " [" + info.value() + "]");
            }
        }
    }
}
