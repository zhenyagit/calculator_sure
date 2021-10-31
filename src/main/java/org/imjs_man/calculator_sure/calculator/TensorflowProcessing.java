package org.imjs_man.calculator_sure.calculator;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.tensorflow.ConcreteFunction;
import org.tensorflow.SavedModelBundle;
import org.tensorflow.Signature;
import org.tensorflow.Tensor;
import org.tensorflow.types.TFloat32;
import org.tensorflow.ndarray.Shape;

import java.io.File;

@Service
@EnableScheduling
public class TensorflowProcessing {
    public void calc(float inp)
    {
//        Shape inpShape = Shape.of(2);
        SavedModelBundle model  = SavedModelBundle.load("C:\\Users\\zhdar\\Documents\\Hackathon_calculator\\calculator_sure\\src\\main\\resources", "serve");
        TFloat32 inputTensor = TFloat32.vectorOf(inp);
        ConcreteFunction function = model.function(Signature.DEFAULT_KEY);
        Tensor result = function.call(inputTensor);
        float[][] resultMatrix = new float[12][2];
    }


}
