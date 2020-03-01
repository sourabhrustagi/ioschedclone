package com.google.samples.apps.shared.domain

import androidx.lifecycle.MutableLiveData
import com.google.samples.apps.shared.domain.internal.DefaultScheduler
import com.google.samples.apps.shared.domain.internal.Scheduler
import com.google.samples.apps.shared.result.Result
import timber.log.Timber
import java.lang.Exception

/**
 * Executes business logic synchronously or asynchronously using a [Scheduler].
 */
abstract class UseCase<in P, R> {
    protected var taskScheduler: Scheduler = DefaultScheduler

    /**
     * Executes the use case asynchronously and places
     */
    operator fun invoke(parameters: P, result: MutableLiveData<Result<R>>) {
        try {
            taskScheduler.execute {
                try {
                    execute(parameters).let { useCaseResult ->
                        result.postValue(Result.Success(useCaseResult))
                    }
                } catch (e: Exception) {
                    Timber.e(e)
                    result.postValue(Result.Error(e))
                }
            }
        } catch (e: Exception) {
            Timber.d(e)
            result.postValue(Result.Error(e))
        }
    }

    @Throws(RuntimeException::class)
    protected abstract fun execute(parameters: P): R
}