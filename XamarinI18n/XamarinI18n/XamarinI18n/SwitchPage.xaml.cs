using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace XamarinI18n
{
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class SwitchPage : ContentPage
    {
        public SwitchPage()
        {
            InitializeComponent();

            //Localize through code-behind - set page content
            //Content = new StackLayout
            //{
            //    Children =
            //    {
            //        welcomeLabel,
            //        switchENButton,
            //        switchITButton
            //    }
            //};
        }

        private void Button_Switch_EN_Clicked(object sender, EventArgs e)
        {
            CultureInfo.CurrentUICulture = new CultureInfo("en", false);
        }

        private void Button_Switch_IT_Clicked(object sender, EventArgs e)
        {
            CultureInfo.CurrentUICulture = new CultureInfo("it", false);

            // To test out app name l10n
            //CultureInfo.CurrentUICulture = new CultureInfo("zh-rCN", false);
        }

        //Localize through code-behind - add UI elements
        //Label welcomeLabel = new Label
        //{
        //    Text = resources.Lang.welcome,
        //};

        //Button switchENButton = new Button
        //{
        //    Text = resources.Lang.switch_en,
        //};

        //Button switchITButton = new Button
        //{
        //    Text = resources.Lang.switch_it,
        //};

        private void DatePickerCurrentDate_DateSelected(object sender, DateChangedEventArgs e)
        {
            LabelCurrentDate.Text = DatePickerCurrentDate.Date.ToString();
        }

        private void Button_Get_TZ_Clicked(object sender, EventArgs e)
        {
            TimeZone currentTimeZone = TimeZone.CurrentTimeZone;
            DateTime currentDate = DateTime.Now;

            TimeSpan currentTimeZoneTimeSpan = currentTimeZone.GetUtcOffset(currentDate);
            LabelCurrentTimeZoneValue.Text = currentTimeZoneTimeSpan.ToString();
        }
    }
}