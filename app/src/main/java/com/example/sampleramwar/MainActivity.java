package com.example.sampleramwar;


import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.view.View;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageView ivCard1;
    private ImageView ivCard2;
    private TextView tvPlayerScore;
    private TextView tvCpuScore;
    private int playerScore = 0;
    private int cpuScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivCard1 = findViewById(R.id.card1);
        ivCard2 = findViewById(R.id.card2);
        tvPlayerScore = findViewById(R.id.tvPlayerScore);
        tvCpuScore = findViewById(R.id.tvCpuScore);
    }

    public void deal(View view) {
        PlayingCard playersCard = PlayingCard.drawRandomCard();
        PlayingCard cpuCard = PlayingCard.drawRandomCard();
        updateCardImages(playersCard, cpuCard);

        if (playersCard.beats(cpuCard)) {
            playerScore++;
            tvPlayerScore.setText(playerScore + "");
        } else if (playersCard.isTie(cpuCard)) {
            Toast message = new Toast(getApplicationContext());
            message.makeText(MainActivity.this, "You tied!", Toast.LENGTH_SHORT).show();
        }
        else {
            cpuScore++;
            tvCpuScore.setText(cpuScore + "");
        }

    }

    private void updateCardImages(PlayingCard playersCard,
                                  PlayingCard cpuCard) {
        int drawableId1 = getIdentifierForImageResource(
                playersCard.getNameForRank("card%d")
        );

        int drawableId2 = getIdentifierForImageResource(
                cpuCard.getNameForRank("card%d")
        );

        ivCard1.setImageDrawable(getDrawable(drawableId1));
        ivCard2.setImageDrawable(getDrawable(drawableId2));
    }

    private int getIdentifierForImageResource(String resourceName) {
        return getResources().getIdentifier(
                resourceName,
                "drawable",
                "com.example.sampleramwar"
        );
    }
}