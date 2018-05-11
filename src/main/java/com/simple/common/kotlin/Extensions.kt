package com.simple.common.kotlin

import android.app.Activity
import android.content.Context
import android.widget.Toast

fun <T> Activity.navTo(cls: Class<in T>) {
    this.startActivity(android.content.Intent(this, cls))
}

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}