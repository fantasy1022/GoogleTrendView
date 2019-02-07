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

package com.fantasy1022.fancytrendapp.data

import android.support.v4.util.ArrayMap
import com.fantasy1022.fancytrendapp.common.modifyFirstCharToUpperCase
import com.fantasy1022.fancytrendapp.data.remote.FancyTrendRestService
import io.reactivex.Single
import java.util.concurrent.TimeUnit

/**
 * Created by fantasy1022 on 2017/2/7.
 */

class TrendRepositoryImpl(private val googleTrendRestService: FancyTrendRestService) : TrendRepository {

    override//TODO:Check  Retry mechanisms, backoff mechanisms and error handling
    val allTrend: Single<ArrayMap<String, List<String>>>
        get() = Single.defer { googleTrendRestService.googleTrend }
                .retry(1)
                .timeout(3, TimeUnit.SECONDS)

    @Throws(Exception::class)
    override suspend fun getAllTrendCoroutine(): Map<String, List<String>> {
        //TODO:Add result to db
        return googleTrendRestService.googleTrendNew.await().map {
            //EX: czech_republic" -> "Czech Republic"
            it.key.replace("_", " ").modifyFirstCharToUpperCase() to it.value
        }.toMap()
    }
}
