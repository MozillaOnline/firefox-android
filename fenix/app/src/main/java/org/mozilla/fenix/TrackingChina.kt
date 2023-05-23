/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package org.mozilla.fenix

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

object TrackingChina {
    fun sendTrackingChina(location: String, action: String, context: Context) {
        val trackingFixedUrl = "https://m.g-fox.cn/cnfenix.gif?"
        var trackingUrl =
            trackingFixedUrl + "location=" + location + "&action=" + action + "&" + (10000..99999).random()
                .toString()
        val trackingRequest = StringRequest(
            Request.Method.GET, trackingUrl,
            {
                try {
                    Log.e("trackingChina", trackingUrl)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        ) { _ ->
            //Toast.makeText(context, volleyError.message, Toast.LENGTH_SHORT).show()
        }
        val requestQueue: RequestQueue = Volley.newRequestQueue(context)
        requestQueue.add(trackingRequest)
    }
}
