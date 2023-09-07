package com.android.bouncingdvd

import android.content.res.Resources
import android.util.TypedValue

class ResourceUtil() {

    fun dpToPx(dp: Float): Float {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, dp, Resources.getSystem().displayMetrics
        )
    }
}