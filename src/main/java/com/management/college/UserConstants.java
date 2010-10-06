/**
 * 
 */
package com.management.college;


/**
 * @author <a href="mailto:sandeep.mandrumaka@gmail.com">Sandeep M</a>
 *
 */
public class UserConstants {
    /*
     * Constants of Phone entity sub-types.
     */
    /**
     * Constant to specify the phone type.
     */
    public static final int    TYPE_PHONE                         = 0;

    /**
     * Constant to specify the Email type.
     */
    public static final int    TYPE_EMAIL_ADDRESS                 = 1;

    /**
     * Constant to specify the IM type.
     */
    public static final int    TYPE_INSTANT_MESSENGER             = 2;

    /**
     * Constant to specify the Url type.
     */
    public static final int    TYPE_URL                           = 3;

    /**
     * constant to specify the number of phone entity types.
     */
    public static final int    PHONE_ENTITY_TYPE_COUNT            = 4;
    
    
    /*
     * User related properties
     */
    /**
     * The name of the property used for allowing the user to signup.
     */
    public static final String   PROP_SIGNUP_ALLOW                = "user.signup.allow";

    /**
     * The name of the property used for making the captcha process.
     */
    public static final String   PROP_SIGN_USE_CAPTCHA            = "user.sign.use_captcha";

    /**
     * The name of the property used for making adddress details of the user.
     */
    public static final String   PROP_SIGNUP_INCLUDE_ADDRESS      = "user.signup.include_address";

    /**
     * The name of the property used to specify address required if any in the signup.
     */
    public static final String   PROP_SIGNUP_ADDRESS_REQUIRED     = "user.signup.address_required";

    /**
     * The name of the property used to specify that user needs approval.
     */
    public static final String   PROP_SIGNUP_NEEDS_APPROVAL       = "user.signup.needs_approval";

    /**
     * The name of the property used to specify that validation required in the signup
     * page.
     */
    public static final String   PROP_SIGNUP_VALIDATION_REQUIRED  = "user.signup.validation_required";

    /**
     * The name of the property used to specify that user should login with email address.
     */
    public static final String   PROP_ACCOUNT_LOGIN_WITH_EMAIL    = "user.account.login_with_email";

    /**
     * The name of the property used to set the minimum length to the user name.
     */
    public static final String   PROP_ACCOUNT_USERNAME_MIN_LENGTH = "user.account.username_min_length";

    /**
     * The name of the property used for making regular expression to the username.
     */
    public static final String   PROP_ACCOUNT_USERNAME_REGEXP     = "user.account.username_regexp";

    /**
     * The name of the property used for notifying the user.
     */
    public static final String   PROP_SIGNUP_NOTIFY_EMAIL         = "user.signup.notify_email";

    /**
     * The name of the property used for notifying the system admin about the new user.
     */
    public static final String   PROP_SIGNUP_NOTIFY_SYS_ADMIN     = "user.signup.notify_sys_admin";

    /**
     * The name of the property used for notifying the company admin about the new user.
     */
    public static final String   PROP_SIGNUP_NOTIFY_COMPANY_ADMIN = "user.signup.notify_company_admin";

    /**
     * The name of the property used for making regular expression to the email address in
     * the signup page..
     */
    public static final String   PROP_SIGNUP_LOGIN_EMAIL_REGEXP   = "user.signup.login_email.regexp";
    
    public static final String   PROP_BLOGS_USER_BLOG_CREATE      = "blogs.user_blog.create";
    
    /**
     * The user property constants count.
     */
    public static final int      PROP_COUNT                       = 14;
    
    /**
     * constant to specify the user filter Properties.
     */
    public static final String[]           userFilterProperties                           = {
        "enabled",
        "username",

        "firstName",
        "lastName",
        "title",
        "role",                                                                          };
    
    /**
     * constant to specify the user filter labels.
     */
    public static final String[]           userFilterLabels                               = {
        "Active",
        "Email Address",

        "First Name",
        "Last Name",
        "Title",
        "Role",                                                                          };
    
    /**
     * constant to specify the user filter data types.
     */
    public static final byte[]             userFilterDataTypes                            = {
        AppConstants.FILTER_DATA_TYPE_BOOLEAN,
        AppConstants.FILTER_DATA_TYPE_STRING,

        AppConstants.FILTER_DATA_TYPE_STRING,
        AppConstants.FILTER_DATA_TYPE_STRING,
        AppConstants.FILTER_DATA_TYPE_CUSTOM,
        AppConstants.FILTER_DATA_TYPE_CUSTOM,                                                };

       
}
