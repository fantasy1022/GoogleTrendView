/*
 * Copyright 2017 Fantasy Fang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fantasy1022.googletrendapp.common;


import android.support.transition.ChangeBounds;
import android.support.transition.Fade;
import android.support.transition.TransitionManager;
import android.support.transition.TransitionSet;

import android.view.ViewGroup;

/**
 * Created by fantasy1022 on 2017/2/22.
 */

public class UiUtils {

    public static void animateForViewGroupTransition(ViewGroup viewGroup) {
        ChangeBounds changeBounds = new ChangeBounds();
        Fade fadeOut = new Fade(Fade.OUT);
        Fade fadeIn = new Fade(Fade.IN);
        TransitionSet transition = new TransitionSet();
        transition.setOrdering(TransitionSet.ORDERING_TOGETHER);
        transition.addTransition(fadeOut)
                .addTransition(changeBounds)
                .addTransition(fadeIn);

        TransitionManager.beginDelayedTransition(viewGroup);
    }

}
