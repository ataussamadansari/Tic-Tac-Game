package com.example.tictac;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;


@SuppressLint("SetTextI18n")
public class MainActivity extends AppCompatActivity {
    TextView btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    String b1, b2, b3, b4, b5, b6, b7, b8, b9;
    String startGame = "X";
    int count = 0;
    int xCount = 0, oCount = 0;
    TextView scoreX, scoreO, reset;
    ImageView termView_xo, termView_ox;
    ImageView cross1, cross2, cross3, cross4, cross5, cross6, cross7, cross8;
    Animation animation;
    Dialog dialog;
    Button oOk, xOk, dOk;
    TextView btnCurrent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        onClickM();


        reset.setOnClickListener(v -> reset());

        termView_ox.setVisibility(View.GONE);
        visibility();


    }

    public void onBtnClick(View v) {
        btnCurrent = (TextView) v;
        if (btnCurrent.getText().toString().equals("")) {

            count++;

            if (startGame.equals("X")) {
                btnCurrent.setText("X");
                startGame = "O";
                termView_xo.setVisibility(View.GONE);
                termView_ox.setVisibility(View.VISIBLE);
            } else {
                btnCurrent.setText("O");
                startGame = "X";
                termView_ox.setVisibility(View.GONE);
                termView_xo.setVisibility(View.VISIBLE);
            }

            if (count > 4) {
                b1 = btn1.getText().toString();
                b2 = btn2.getText().toString();
                b3 = btn3.getText().toString();
                b4 = btn4.getText().toString();
                b5 = btn5.getText().toString();
                b6 = btn6.getText().toString();
                b7 = btn7.getText().toString();
                b8 = btn8.getText().toString();
                b9 = btn9.getText().toString();

                //condition
                if (b1.equals(b2) && b1.equals(b3) && !b1.equals("")) {
                    cross1.setVisibility(View.VISIBLE);
                    disBtn();
                    animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.cross_h);
                    cross1.startAnimation(animation);
                    new Handler().postDelayed(this::winDialog, 1000);

                } else if (b4.equals(b5) && b4.equals(b6) && !b4.equals("")) {
                    cross2.setVisibility(View.VISIBLE);
                    disBtn();
                    animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.cross_h);
                    cross2.startAnimation(animation);
                    new Handler().postDelayed(this::winDialog, 1000);

                } else if (b7.equals(b8) && b7.equals(b9) && !b7.equals("")) {
                    cross3.setVisibility(View.VISIBLE);
                    disBtn();
                    animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.cross_h);
                    cross3.startAnimation(animation);
                    new Handler().postDelayed(this::winDialog, 1000);

                } else if (b1.equals(b4) && b1.equals(b7) && !b1.equals("")) {
                    cross4.setVisibility(View.VISIBLE);
                    disBtn();
                    animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.cross_v);
                    cross4.startAnimation(animation);
                    new Handler().postDelayed(this::winDialog, 1000);

                } else if (b2.equals(b5) && b2.equals(b8) && !b2.equals("")) {
                    cross5.setVisibility(View.VISIBLE);
                    disBtn();
                    animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.cross_v);
                    cross5.startAnimation(animation);
                    new Handler().postDelayed(this::winDialog, 1000);

                } else if (b3.equals(b6) && b3.equals(b9) && !b3.equals("")) {
                    cross6.setVisibility(View.VISIBLE);
                    disBtn();
                    animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.cross_v);
                    cross6.startAnimation(animation);
                    new Handler().postDelayed(this::winDialog, 1000);

                } else if (b1.equals(b5) && b1.equals(b9) && !b1.equals("")) {
                    cross7.setVisibility(View.VISIBLE);
                    disBtn();
                    animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.cross_7);
                    cross7.startAnimation(animation);
                    new Handler().postDelayed(this::winDialog, 1000);

                } else if (b3.equals(b5) && b3.equals(b7) && !b3.equals("")) {
                    cross8.setVisibility(View.VISIBLE);
                    disBtn();
                    animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.cross_8);
                    cross8.startAnimation(animation);
                    new Handler().postDelayed(this::winDialog, 1000);

                } else if (!b1.equals("") && !b2.equals("") && !b3.equals("")
                        && !b4.equals("") && !b5.equals("") && !b6.equals("")
                        && !b7.equals("") && !b8.equals("") && !b9.equals("")) {
                    Toast.makeText(this, "Match Draw!", Toast.LENGTH_SHORT).show();
                    new Handler().postDelayed(this::drawDialoag, 1000);
                }


            }
        }
    }

    public void reset() {
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        startGame = "X";
        enBtn();
        termView_xo.setVisibility(View.VISIBLE);
        termView_ox.setVisibility(View.GONE);
        xCount = 0;
        oCount = 0;
        count = 0;
        scoreX.setText("Score X:- " + xCount);
        scoreO.setText(oCount + " -:Score O");

    }

    public void newGame() {
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        visibility();
        count = 0;
        if (startGame.equals("O")) {
            startGame = "X";
            enBtn();
            termView_xo.setVisibility(View.VISIBLE);
            termView_ox.setVisibility(View.GONE);
            scoreX.setText("Score X:- " + ++xCount);

        } else {
            startGame = "O";
            enBtn();
            termView_ox.setVisibility(View.VISIBLE);
            termView_xo.setVisibility(View.GONE);
            scoreO.setText(++oCount + " -:Score O");
        }

    }

    private void onClickM() {
        btn1.setOnClickListener(v -> onBtnClick(btn1));
        btn2.setOnClickListener(v -> onBtnClick(btn2));
        btn3.setOnClickListener(v -> onBtnClick(btn3));
        btn4.setOnClickListener(v -> onBtnClick(btn4));
        btn5.setOnClickListener(v -> onBtnClick(btn5));
        btn6.setOnClickListener(v -> onBtnClick(btn6));
        btn7.setOnClickListener(v -> onBtnClick(btn7));
        btn8.setOnClickListener(v -> onBtnClick(btn8));
        btn9.setOnClickListener(v -> onBtnClick(btn9));
    }

    private void init() {
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        reset = findViewById(R.id.reset);
        scoreX = findViewById(R.id.xUser);
        scoreO = findViewById(R.id.oUser);
        cross1 = findViewById(R.id.cross1);
        cross2 = findViewById(R.id.cross2);
        cross3 = findViewById(R.id.cross3);
        cross4 = findViewById(R.id.cross4);
        cross5 = findViewById(R.id.cross5);
        cross6 = findViewById(R.id.cross6);
        cross7 = findViewById(R.id.cross7);
        cross8 = findViewById(R.id.cross8);
        termView_xo = findViewById(R.id.x_to_o);
        termView_ox = findViewById(R.id.o_to_x);
    }

    private void visibility() {
        cross1.setVisibility(View.GONE);
        cross2.setVisibility(View.GONE);
        cross3.setVisibility(View.GONE);
        cross4.setVisibility(View.GONE);
        cross5.setVisibility(View.GONE);
        cross6.setVisibility(View.GONE);
        cross7.setVisibility(View.GONE);
        cross8.setVisibility(View.GONE);
    }

    private void draw() {
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        visibility();
        count = 0;
    }

    private void drawDialoag() {
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.draw_game);
        Objects.requireNonNull(dialog.getWindow()).setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        dOk = dialog.findViewById(R.id.dOk);

        dialog.show();

        dOk.setOnClickListener(v1 -> {
            draw();
            dialog.dismiss();
        });
    }

    public void winDialog() {
        if (startGame.equals("O")) {
            dialog = new Dialog(this);
            dialog.setContentView(R.layout.x_win);
            Objects.requireNonNull(dialog.getWindow()).setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.setCancelable(false);
            xOk = dialog.findViewById(R.id.xOk);

            dialog.show();

            xOk.setOnClickListener(v -> {
                newGame();
                dialog.dismiss();
            });

        } else {

            dialog = new Dialog(this);
            dialog.setContentView(R.layout.o_win);
            Objects.requireNonNull(dialog.getWindow()).setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.setCancelable(false);
            oOk = dialog.findViewById(R.id.oOk);

            dialog.show();

            oOk.setOnClickListener(v -> {
                newGame();
                dialog.dismiss();
            });
        }
    }

    private void enBtn() {
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        btn4.setEnabled(true);
        btn5.setEnabled(true);
        btn6.setEnabled(true);
        btn7.setEnabled(true);
        btn8.setEnabled(true);
        btn9.setEnabled(true);
    }

    private void disBtn() {
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);
        btn7.setEnabled(false);
        btn8.setEnabled(false);
        btn9.setEnabled(false);
    }
}