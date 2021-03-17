using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Localization;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;
using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Reflection;
using System.Resources;
using System.Threading.Tasks;

namespace ASPNETCoreL10n
{
    public class Startup
    {
        // This method gets called by the runtime. Use this method to add services to the container.
        // For more information on how to configure your application, visit https://go.microsoft.com/fwlink/?LinkID=398940
        public void ConfigureServices(IServiceCollection services)
        {
            // Make it MVC
            services.AddControllersWithViews(); 
            services.AddRazorPages().AddViewLocalization();

            // With .NET ResourceManager
            string baseName = "ASPNETCoreL10n.Controllers.HomeController";
            services.AddSingleton(new ResourceManager(baseName, Assembly.GetExecutingAssembly()));

            // Using IStringLocalizer
            services.AddLocalization();
        }

        // This method gets called by the runtime. Use this method to configure the HTTP request pipeline.
        public void Configure(IApplicationBuilder app, IWebHostEnvironment env)
        {
            if (env.IsDevelopment())
            {
                app.UseDeveloperExceptionPage();
            }


            // Get help of UseRequestLocalization
            var supportedCultures = new[] {new CultureInfo("en-US"), new CultureInfo("fr-FR")};
            var requestLocalizationOptions = new RequestLocalizationOptions
            {
                // For culture-specific formatting of numbers, dates, etc.
                SupportedCultures = supportedCultures,
                // For l10n of UI-related elements, e.g., strings.
                SupportedUICultures = supportedCultures,
            };

            // Using CustomRequestCultureProvider
            //requestLocalizationOptions.AddInitialRequestCultureProvider(new CustomRequestCultureProvider(async context =>
            //{
            //    var currentCulture = "en-US";
            //    var segments = context.Request.Path.Value.Split(new char[] { '/' },
            //        StringSplitOptions.RemoveEmptyEntries);

            //    if (segments.Length > 0)
            //    {
            //        var lastElement = segments[segments.Length - 1];
            //        if (lastElement.Length == 2 || lastElement.Length == 5)
            //        {
            //            currentCulture = lastElement;
            //        }
            //    }

            //    return new ProviderCultureResult(currentCulture);
            //}));

            requestLocalizationOptions.DefaultRequestCulture = new RequestCulture("en-US");

            app.UseRequestLocalization(requestLocalizationOptions);


            // Make it MVC
            app.UseRouting(); 

            app.UseEndpoints(endpoints =>
            {
                endpoints.MapControllerRoute(
                    name: "default",
                    pattern: "{controller=home}/{action=index}/{id?}");
            });
        }
    }
}
