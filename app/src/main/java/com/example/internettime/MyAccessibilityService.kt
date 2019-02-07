package com.example.internettime

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.AccessibilityServiceInfo
import android.util.Log
import android.view.accessibility.AccessibilityEvent


class MyAccessibilityService : AccessibilityService() {
    override fun onInterrupt() {
        Log.d("AccService", "They want to interrupt me!")
        // TODO do something when service is interrupted
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        val packageName = event!!.packageName
        Log.d("AccService", "$packageName is opened now")
    }

    override fun onServiceConnected() {
        Log.d("AccService", "onConnected()")
        super.onServiceConnected()
        setEventTypes()
    }

    override fun onDestroy() {
        Log.d("AccService", "I am destroyed")
        super.onDestroy()
    }

    private fun setEventTypes() {
        val info = AccessibilityServiceInfo()
        info.eventTypes = AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED or
                AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED or AccessibilityEvent.TYPE_VIEW_CLICKED or
                AccessibilityEvent.TYPE_VIEW_FOCUSED or AccessibilityEvent.TYPE_VIEW_SCROLLED
        info.feedbackType = AccessibilityServiceInfo.FEEDBACK_GENERIC
        this.serviceInfo = info
    }
}
