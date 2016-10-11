/**
 * File     : MainActivity.java
 * Project  : TemplateActivity
 * Author   : Markus Jaton 2 juillet 2014
 * 			  Fabien Dutoit 20 septembre 2016
 *            IICT / HEIG-VD
 *                                       
 * mailto:fabien.dutoit@heig-vd.ch
 * 
 * This piece of code reads a [email_account / password ] combination.
 * It is used as a template project for the SYM module element given at HEIG-VD
 * Target audience : students IL, TS, IE [generally semester 1, third bachelor year]
 *   
 * THIS SOFTWARE IS PROVIDED "AS IS" AND ANY EXPRESSED OR IMPLIED WARRANTIES,
 * INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY 
 * AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL 
 * THE REGENTS OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, 
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED 
 * TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF 
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS 
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * 
 */
package ch.heigvd.sym.template;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // For logging purposes
    private static final String TAG = MainActivity.class.getSimpleName();

    // Just for test purposes : please destroy !
	private static final String validEmail      = "toto@tutu.com";
	private static final String validPassword   = "tata";

    // GUI elements
	private EditText email      = null;
	private EditText password      = null;
    private Button   signIn     = null;

	/*Cette méthode est appélé quand l'activité n'est plus visible par
	* le user et tourne en background. Dans cette exemple, lorsque le user
	* sera authentifié, cette activité va tourner en background et ainsi
	* la methéde onPause sera appélé juste avant de quitter l'écran.
	*/
	@Override
	protected void onPause() {
		super.onPause();
		Toast.makeText(MainActivity.this, "The main activity goes on pause...", Toast.LENGTH_LONG).show();
	}

	/*Cette méthode est appélée 1 milliseconde après que l'activité ira en
	* backgroung.Par conséquent elle sera exécuté juste après l'exécution de
	* la méthode OnPause().
	*/
	@Override
	protected void onStop() {
		super.onStop();
		Toast.makeText(MainActivity.this, "The main activity stops just after goes on pause...", Toast.LENGTH_LONG).show();
	}

	/*Cette méthode est appélé quand l'activité principale est lancé et visible
	* par le user. D'abord le méthode onCreate() sera exécutée, ensuite cette
	* méthode. Elle sera aussi exécutée dès que l'activité est reprise par le
	* user aprés une pause (onPause()).
	* */
	@Override
	protected void onStart() {
		super.onStart();
		Toast.makeText(MainActivity.this, "The main activity starts...", Toast.LENGTH_LONG).show();
	}

    /*De même que onStart, cette méthode est appélée lorsque l'activité principale
    * est lancée et visible à l'écran. Elle est exécuté après la méthode onStart.
    */
	@Override
	protected void onResume() {
		super.onResume();
		Toast.makeText(MainActivity.this, "OnResume is called after the call of onStart...", Toast.LENGTH_LONG).show();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		// Show the welcome screen / login authentication dialog
		setContentView(R.layout.authen_relative_layout);

		// Link to GUI elements
        this.email      = (EditText) findViewById(R.id.email);
		this.password      = (EditText) findViewById(R.id.password);
        this.signIn     = (Button)   findViewById(R.id.buttOk);

		// Then program action associated to "Ok" button
		signIn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				/*
				 * There you have to check out if the email/password
				 * combination given is valid or not
				 */
				String mail = email.getText().toString();
				String passwd = password.getText().toString();

				if(mail.indexOf("@") <= 0){
					Toast.makeText(MainActivity.this, getResources().getString(R.string.invalidEmail), Toast.LENGTH_LONG).show();
				}
				else if (isValid(mail, passwd)) {
					/* Ok, valid combination, do something or launch another activity...
					 * The current activity could be finished, but it is not mandatory.
					 * To launch activity MyActivity.class, try something like :
					 * 
					 * 			Intent intent = new Intent(this, ch.heigvd.sym.MyActivity.class);
					 * 			intent.putExtra("emailEntered", mail);
					 *			intent.putExtra("passwordGiven", passwd);
					 *			this.startActivity(intent); 
					 *
					 * Alternately, you could also startActivityForResult if you are awaiting a result.
					 * In the latter case, you have to indicate an int parameter to identify MyActivity
					 * 
					 * If you haven't anything more to do, you may finish()...
					 * But just display a small message before quitting...
					 */

					Intent intent = new Intent(MainActivity.this, SuccessActivity.class);
					intent.putExtra(SuccessActivity.emailEntered, mail);
					intent.putExtra(SuccessActivity.passwordGiven, passwd);
					startActivity(intent);

					Toast.makeText(MainActivity.this, getResources().getString(R.string.good), Toast.LENGTH_LONG).show();
					finish();
				} else {
					// Wrong combination, display pop-up dialog and stay on login screen
					showErrorDialog(mail, passwd);
					email.setText("");
					password.setText("");
				}
			}
			
		});
	}
	
	protected boolean isValid(String mail, String passwd) {
        if(mail == null || passwd == null) {
            Log.w(TAG, "isValid(mail, passwd) - mail and passwd cannot be null !");
            return false;
        }
		// Return true if combination valid, false otherwise
		return (mail.equals(validEmail) && passwd.equals(validPassword));
	}
	
	protected void showErrorDialog(String mail, String passwd) {
		/*
		 * Pop-up dialog to show error
		 */
		AlertDialog.Builder alertbd = new AlertDialog.Builder(this);
        alertbd.setIcon(android.R.drawable.ic_dialog_alert);
		alertbd.setTitle(R.string.wronglogin);
	    alertbd.setMessage(R.string.wrong);
	    alertbd.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog, int which) { 
	            // we do nothing...
                // dialog close automatically
	        }
	     });
	    alertbd.show();
	}
	
}
