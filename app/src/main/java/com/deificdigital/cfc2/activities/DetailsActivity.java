package com.deificdigital.cfc2.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.deificdigital.cfc2.R;
import com.deificdigital.cfc2.forms.AdvertisementForm;
import com.deificdigital.cfc2.forms.BirthForm;
import com.deificdigital.cfc2.forms.BookingForm;
import com.deificdigital.cfc2.forms.CattleForm;
import com.deificdigital.cfc2.forms.CivilWorkForm;
import com.deificdigital.cfc2.forms.DeathForm;
import com.deificdigital.cfc2.forms.DogForm;
import com.deificdigital.cfc2.forms.EncroachmentForm;
import com.deificdigital.cfc2.forms.GarbageCollectionForm;
import com.deificdigital.cfc2.forms.HouseTaxAssessmentForm;
import com.deificdigital.cfc2.forms.HouseTaxRenewalForm;
import com.deificdigital.cfc2.forms.LightningForm;
import com.deificdigital.cfc2.forms.MiscellaneousForm;
import com.deificdigital.cfc2.forms.MutationForm;
import com.deificdigital.cfc2.forms.OutsourcingForm;
import com.deificdigital.cfc2.forms.PensionForm;
import com.deificdigital.cfc2.forms.SewerageAssessmentForm;
import com.deificdigital.cfc2.forms.SewerageComplaintForm;
import com.deificdigital.cfc2.forms.SewerageTaxForm;
import com.deificdigital.cfc2.forms.SewerageWaterForm;
import com.deificdigital.cfc2.forms.TradeLicenseForm;
import com.deificdigital.cfc2.forms.TradeTaxForm;
import com.deificdigital.cfc2.forms.UdyanForm;
import com.deificdigital.cfc2.forms.WaterAssessmentForm;
import com.deificdigital.cfc2.forms.WaterComplaintForm;
import com.deificdigital.cfc2.forms.WaterMutationForm;

public class DetailsActivity extends AppCompatActivity {

    TextView title;
    ConstraintLayout llApplyNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        title = findViewById(R.id.title);
        llApplyNow = findViewById(R.id.llApplyNow);


        Intent i = getIntent();
        String birthtitle = i.getStringExtra("titleFirst");
        String tradetitle = i.getStringExtra("titleSecond");
        String housetitle = i.getStringExtra("titleThird");
        String deathtitle = i.getStringExtra("titleFourth");
        String mutationtitle = i.getStringExtra("titleFifth");
        String garbagetitle = i.getStringExtra("titleSixth");
        String watertitle = i.getStringExtra("titleSeventh");

        String dogtitle = i.getStringExtra("titleEighth");
        String cattletitle = i.getStringExtra("titleNinth");
        String udyaantitle = i.getStringExtra("titleTenth");
        String civiltitle = i.getStringExtra("titleEleventh");
        String seweragetitle = i.getStringExtra("titleTwelfth");
        String seweragetaxtitle = i.getStringExtra("titleThirteenth");
        String sewerageassessmenttitle = i.getStringExtra("titleFourteenth");
        String watertaxtitle = i.getStringExtra("titleFifteenth");
        String watermutationtitle = i.getStringExtra("titleSixteenth");
        String lightningtitle = i.getStringExtra("titleSeventeenth");
        String housetaxtitle = i.getStringExtra("titleEighteenth");
        String bookingtitle = i.getStringExtra("titleNineteenth");
        String pensiontitle = i.getStringExtra("titleTwentieth");
        String tradelicensetitle = i.getStringExtra("titleTwentyFirst");
        String adstitle = i.getStringExtra("titleTwentySecond");
        String outsourcingtitle = i.getStringExtra("titleTwentyThird");
        String encrochmenttitle = i.getStringExtra("titleTwentyFourth");
        String miscellaneoustitle = i.getStringExtra("titleTwentyFifth");
        String seweragecomplainttitle = i.getStringExtra("titleTwentySixth");

        int reqCodeFirst = i.getIntExtra("requestCode", 0);
        int reqCodeSecond = i.getIntExtra("requestCode", 0);
        int reqCodeThird = i.getIntExtra("requestCode", 0);
        int reqCodeFourth = i.getIntExtra("requestCode", 0);
        int reqCodeFifth = i.getIntExtra("requestCode", 0);
        int reqCodeSixth = i.getIntExtra("requestCode", 0);
        int reqCodeSeventh = i.getIntExtra("requestCode", 0);

        int reqCodeEighth = i.getIntExtra("requestCode", 0);
        int reqCodeNinth = i.getIntExtra("requestCode", 0);
        int reqCodeTenth = i.getIntExtra("requestCode", 0);
        int reqCodeEleventh = i.getIntExtra("requestCode", 0);
        int reqCodeTwelfth = i.getIntExtra("requestCode", 0);
        int reqCodeThirteenth = i.getIntExtra("requestCode", 0);
        int reqCodeFourteenth = i.getIntExtra("requestCode", 0);
        int reqCodeFifteenth = i.getIntExtra("requestCode", 0);
        int reqCodeSixteenth = i.getIntExtra("requestCode", 0);
        int reqCodeSeventeenth = i.getIntExtra("requestCode", 0);
        int reqCodeEighteenth = i.getIntExtra("requestCode", 0);
        int reqCodeNineteenth = i.getIntExtra("requestCode", 0);
        int reqCodeTwentieth = i.getIntExtra("requestCode", 0);
        int reqCodeTwentyFirst = i.getIntExtra("requestCode", 0);
        int reqCodeTwentySecond = i.getIntExtra("requestCode", 0);
        int reqCodeTwentyThird = i.getIntExtra("requestCode", 0);
        int reqCodeTwentyFourth = i.getIntExtra("requestCode", 0);
        int reqCodeTwentyFifth = i.getIntExtra("requestCode", 0);
        int reqCodeTwentySixth = i.getIntExtra("requestCode", 0);

        if (reqCodeFirst == 1){
            title.setText(birthtitle);
        }
        if (reqCodeSecond == 2){
            title.setText(tradetitle);
        }
        if (reqCodeThird == 3){
            title.setText(housetitle);
        }
        if (reqCodeFourth == 4){
            title.setText(deathtitle);
        }
        if (reqCodeFifth == 5){
            title.setText(mutationtitle);
        }
        if (reqCodeSixth == 6){
            title.setText(garbagetitle);
        }
        if (reqCodeSeventh == 7){
            title.setText(watertitle);
        }


        if (reqCodeEighth == 8){
            title.setText(dogtitle);
        }
        if (reqCodeNinth == 9){
            title.setText(cattletitle);
        }
        if (reqCodeTenth == 10){
            title.setText(udyaantitle);
        }
        if (reqCodeEleventh == 11){
            title.setText(civiltitle);
        }
        if (reqCodeTwelfth == 12){
            title.setText(seweragetitle);
        }
        if (reqCodeThirteenth == 13){
            title.setText(seweragetaxtitle);
        }
        if (reqCodeFourteenth == 14){
            title.setText(sewerageassessmenttitle);
        }
        if (reqCodeFifteenth == 15){
            title.setText(watertaxtitle);
        }
        if (reqCodeSixteenth == 16){
            title.setText(watermutationtitle);
        }
        if (reqCodeSeventeenth == 17){
            title.setText(lightningtitle);
        }
        if (reqCodeEighteenth == 18){
            title.setText(housetaxtitle);
        }
        if (reqCodeNineteenth == 19){
            title.setText(bookingtitle);
        }
        if (reqCodeTwentieth == 20){
            title.setText(pensiontitle);
        }
        if (reqCodeTwentyFirst == 21){
            title.setText(tradelicensetitle);
        }
        if (reqCodeTwentySecond == 22){
            title.setText(adstitle);
        }
        if (reqCodeTwentyThird == 23){
            title.setText(outsourcingtitle);
        }
        if (reqCodeTwentyFourth == 24){
            title.setText(encrochmenttitle);
        }
        if (reqCodeTwentyFifth == 25){
            title.setText(miscellaneoustitle);
        }
        if (reqCodeTwentySixth == 26){
            title.setText(seweragecomplainttitle);
        }

        llApplyNow.setOnClickListener(v -> {
            if(reqCodeFirst == 1) {
                startActivity(new Intent(DetailsActivity.this, BirthForm.class));
            }
            else if(reqCodeSecond == 2){
                startActivity(new Intent(DetailsActivity.this, TradeTaxForm.class));
            }
            else if (reqCodeThird == 3) {
                startActivity(new Intent(DetailsActivity.this, HouseTaxAssessmentForm.class));
            }
            else if (reqCodeFourth == 4) {
                startActivity(new Intent(DetailsActivity.this, DeathForm.class));
            }
            else if (reqCodeFifth == 5) {
                startActivity(new Intent(DetailsActivity.this, MutationForm.class));
            }
            else if (reqCodeSixth == 6) {
                startActivity(new Intent(DetailsActivity.this, GarbageCollectionForm.class));
            }
            else if (reqCodeSeventh == 7) {
                startActivity(new Intent(DetailsActivity.this, WaterComplaintForm.class));
            }
            else if (reqCodeEighth == 8) {
                startActivity(new Intent(DetailsActivity.this, DogForm.class));
            }
            else if (reqCodeNinth == 9) {
                startActivity(new Intent(DetailsActivity.this, CattleForm.class));
            }
            else if (reqCodeTenth == 10) {
                startActivity(new Intent(DetailsActivity.this, UdyanForm.class));
            }
            else if (reqCodeEleventh == 11) {
                startActivity(new Intent(DetailsActivity.this, CivilWorkForm.class));
            }
            else if (reqCodeTwelfth == 12) {
                startActivity(new Intent(DetailsActivity.this, SewerageWaterForm.class));
            }
            else if (reqCodeThirteenth == 13) {
                startActivity(new Intent(DetailsActivity.this, SewerageTaxForm.class));
            }
            else if (reqCodeFourteenth == 14) {
                startActivity(new Intent(DetailsActivity.this, SewerageAssessmentForm.class));
            }
            else if (reqCodeFifteenth == 15) {
                startActivity(new Intent(DetailsActivity.this, WaterAssessmentForm.class));
            }
            else if (reqCodeSixteenth == 16) {
                startActivity(new Intent(DetailsActivity.this, WaterMutationForm.class));
            }
            else if (reqCodeSeventeenth == 17) {
                startActivity(new Intent(DetailsActivity.this, LightningForm.class));
            }
            else if (reqCodeEighteenth == 18) {
                startActivity(new Intent(DetailsActivity.this, HouseTaxRenewalForm.class));
            }
            else if (reqCodeNineteenth == 19) {
                startActivity(new Intent(DetailsActivity.this, BookingForm.class));
            }
            else if (reqCodeTwentieth == 20) {
                startActivity(new Intent(DetailsActivity.this, PensionForm.class));
            }
            else if (reqCodeTwentyFirst == 21) {
                startActivity(new Intent(DetailsActivity.this, TradeLicenseForm.class));
            }
            else if (reqCodeTwentySecond == 22) {
                startActivity(new Intent(DetailsActivity.this, AdvertisementForm.class));
            }
            else if (reqCodeTwentyThird == 23) {
                startActivity(new Intent(DetailsActivity.this, OutsourcingForm.class));
            }
            else if (reqCodeTwentyFourth == 24) {
                startActivity(new Intent(DetailsActivity.this, EncroachmentForm.class));
            }
            else if (reqCodeTwentyFifth == 25) {
                startActivity(new Intent(DetailsActivity.this, MiscellaneousForm.class));
            }
            else if (reqCodeTwentySixth == 26) {
                startActivity(new Intent(DetailsActivity.this, SewerageComplaintForm.class));
            }
        });
    }
}