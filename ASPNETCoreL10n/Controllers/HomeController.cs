using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Localization;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Localization;
using Microsoft.Extensions.Localization;
using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Resources;
using System.Threading;
using System.Threading.Tasks;

namespace ASPNETCoreL10n.Controllers
{
    public class HomeController : Controller
    {
        private readonly ResourceManager _resourceManager;
        private readonly IStringLocalizer _stringLocalizer;
        private readonly IHtmlLocalizer _htmlLocalizer;
        private readonly IStringLocalizer _sharedStringLocalizer;
        public HomeController(ResourceManager resourceManager,
                              IStringLocalizer<HomeController> stringLocalizer,
                              IHtmlLocalizer<HomeController> htmlLocalizer,
                              IStringLocalizer<SharedResource> sharedStringLocalizer)
        {
            _resourceManager = resourceManager;
            _stringLocalizer = stringLocalizer;
            _htmlLocalizer = htmlLocalizer;
            _sharedStringLocalizer = sharedStringLocalizer;
        }

        public IActionResult Index()
        {
            ViewData["greeting"] = _resourceManager.GetString("welcome");

            return View();
        }

        public IActionResult UsingIStringLocalizer()
        {
            ViewData["localized"] = _stringLocalizer["localizedUsingIStringLocalizer"].Value;
            //Used to test StringLocalizer behavior for missing resources
            //ViewData["localized"] = _stringLocalizer["nonexistingkey"].Value;

            return View();
        }

        public IActionResult UsingIHtmlLocalizer()
        {
            ViewData["localizedPreservingHtml"] = _htmlLocalizer["notHtmlEncoded"];

            return View();
        }

        public IActionResult UsingIViewLocalizer() 
        { 
            return View(); 
        }
        public IActionResult UsingSharedResource()
        {
            ViewData["sharedResourceSentFromController"] = _sharedStringLocalizer["localizedUsingSharedResources"];

            return View();
        }

        [Route("Home/UsingCookieRequestCultureProvider/{culture}")]
        public string UsingCookieRequestCultureProvider(string culture)
        {
            Response.Cookies.Append(
                CookieRequestCultureProvider.DefaultCookieName,
                CookieRequestCultureProvider.MakeCookieValue(new RequestCulture(culture)),
                new CookieOptions { Expires = DateTimeOffset.UtcNow.AddYears(1) }
            );

            return "Cookie updated to this culture: " + culture;
        }

        public string CurrentDateTimeL10n()
        {
            return DateTime.Now.ToLongDateString();
        }

        [Route("Home/Welcome/{name}")]
        public string Welcome(string name)
        {
            return _stringLocalizer["welcomeWithName", name];
        }
    }
}
