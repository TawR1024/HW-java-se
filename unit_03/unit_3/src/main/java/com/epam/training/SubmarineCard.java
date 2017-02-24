package com.epam.training;

import java.lang.annotation.*;
import java.util.Date;

/**
 * Created by Ilya Kulakov on 24.02.17.
 */
@Documented
@Inherited
@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.SOURCE)
public @interface SubmarineCard {
    String chiefDesigner();

    String laidDownDate();

    String portOfRegestry() default "Novorossiysk";

    int yardNumber();


}
