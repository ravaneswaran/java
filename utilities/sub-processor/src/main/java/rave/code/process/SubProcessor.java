package rave.code.process;

import rave.code.utility.log.JavaUtilLogDecor;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hello world!
 */
public class SubProcessor {

    private static final Logger LOGGER = Logger.getLogger(SubProcessor.class.getName());

    public static AbstractSubProcess createSubProcess(Class program) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return (AbstractSubProcess)program.getDeclaredConstructor().newInstance();
    }

    public static void main(String[] args) {
        JavaUtilLogDecor.setupLogDecor();
        try {
            SubProcessor.createSubProcess(TestSubProcess.class).setUp().start().action().exit();
        } catch (InterruptedException interruptedException) {
            LOGGER.log(Level.SEVERE, interruptedException.getMessage(), interruptedException);
        } catch (IOException ioException) {
            LOGGER.log(Level.SEVERE, ioException.getMessage(), ioException);
        } catch (NoSuchMethodException noSuchMethodException) {
            LOGGER.log(Level.SEVERE, noSuchMethodException.getMessage(), noSuchMethodException);
        } catch (InvocationTargetException invocationTargetException) {
            LOGGER.log(Level.SEVERE, invocationTargetException.getMessage(), invocationTargetException);
        } catch (InstantiationException instantiationException) {
            LOGGER.log(Level.SEVERE, instantiationException.getMessage(), instantiationException);
        } catch (IllegalAccessException illegalAccessException) {
            LOGGER.log(Level.SEVERE, illegalAccessException.getMessage(), illegalAccessException);
        }
    }
}
