package com.aware.plugin.goodmorning;

import android.content.Context;
import android.content.Intent;
import android.content.BroadcastReceiver;

import com.aware.ESM;

public class AlarmReceiver extends BroadcastReceiver {
    private static final String MORNINGJSON = "[{'esm':{" +
            "'esm_type':" + ESM.TYPE_ESM_TEXT + "," +
            "'esm_title': 'How did you sleep?'," +
            "'esm_instructions': 'How did you sleep last night? Please provide an estimate on a scale from 1 (worst) to 10 (best) as well as a written description of your night!'," +
            "'esm_submit': 'Submit.'," +
            "'esm_expiration_threashold': 300," + //the user has 5 minutes to respond. Set to 0 to disable
            "'esm_trigger': 'com.aware.plugin.goodmorning'" +
            "}}]";

    public AlarmReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent queue_esm = new Intent(ESM.ACTION_AWARE_QUEUE_ESM);
        String esmJSON = MORNINGJSON;
        queue_esm.putExtra(ESM.EXTRA_ESM, esmJSON);
        context.sendBroadcast(queue_esm);
    }
}