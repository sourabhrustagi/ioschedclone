package com.google.samples.apps.iosched.test.util

import com.google.samples.apps.shared.domain.internal.DefaultScheduler
import com.google.samples.apps.shared.domain.internal.SyncScheduler
import org.junit.rules.TestWatcher
import org.junit.runner.Description

class SyncTaskExecutorRule : TestWatcher() {
    override fun starting(description: Description?) {
        super.starting(description)
        DefaultScheduler.setDelegate(SyncScheduler)
    }

    override fun finished(description: Description?) {
        super.finished(description)
        SyncScheduler.clearScheduledPostdelayedTasks()
        DefaultScheduler.setDelegate(null)
    }

    fun runAllScheduledPostDelayedTasks() {
        SyncScheduler.runAllSchedulerPostDelayedTasks()
    }
}