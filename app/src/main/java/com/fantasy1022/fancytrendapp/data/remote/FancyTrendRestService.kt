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

package com.fantasy1022.fancytrendapp.data.remote


import android.support.v4.util.ArrayMap
import io.reactivex.Single
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

/**
 * Created by fantasy1022 on 2017/2/7.
 */
interface FancyTrendRestService {

    @get:GET("internal/data")
    val googleTrend: Single<ArrayMap<String, List<String>>>//TODO:Remove

    @get:GET("internal/data")
    val googleTrendNew: Deferred<ArrayMap<String, List<String>>>
}
