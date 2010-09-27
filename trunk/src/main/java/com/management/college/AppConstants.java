package com.management.college;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 */
public class AppConstants {

    /**
     * Project level constant for the type GLOBAL.
     */
    public static final int          ENTITY_TYPE_GLOBAL                    = 0;

    // ------------ Core module Entity types.--------------//

    /**
     * Project level constant for the type User.
     */
    public static final int          ENTITY_TYPE_CORE_USER                 = 1;

    /**
     * Project level constant for the type Role.
     */
    public static final int          ENTITY_TYPE_CORE_ROLE                 = 2;
    
    /**
     * Project level constant for the type student.
     */
	public static final int ENTITY_TYPE_CORE_STUDENT = 3;

    // ------------ Contact module Entity types.--------------

    /**
     * Project level constant for the type Address.
     */
    public static final int          ENTITY_TYPE_CONTACT_ADDRESS           = 21;

    /**
     * Project level constant for the type Contact.
     */
    public static final int          ENTITY_TYPE_CONTACT                   = 22;

    /**
     * Project level constant for the type Contact Group
     */
    public static final int          ENTITY_TYPE_CONTACT_GROUP             = 23;

    /**
     * Project level constant for the type Contact List
     */
    public static final int          ENTITY_TYPE_CONTACT_LIST              = 24;

    /**
     * Project level constant for the type Contact List
     */
    public static final int          ENTITY_TYPE_CONTACT_MAPPING           = 25;

    /**
     * Project level constant for the type Phone.
     */
    public static final int          ENTITY_TYPE_CONTACT_PHONE             = 26;

    /**
     * Project level constant for the type PersonName.
     */
    public static final int          ENTITY_TYPE_CONTACT_PERSON_NAME       = 27;

    // --------- Util module entity types.-------------------

    /**
     * Project level constant for the type DecodeGroup.
     */
    public static final int          ENTITY_TYPE_UTIL_DECODE_GROUP         = 44;

    /**
     * Project level constant for the type DecodeValue.
     */
    public static final int          ENTITY_TYPE_UTIL_DECODE_VALUE         = 45;

    // --------- MediaFile module entity types.-------------------

    /**
     * Project level constant for the type MediaFile.
     */
    public static final int          ENTITY_TYPE_MEDIA_FILE                = 61;

    /**
     * Project level constant for the type MediaRepository.
     */
    public static final int          ENTITY_TYPE_MEDIA_REPOSITORY          = 62;

    /**
     * Project level constant for the type MediaFolder.
     */
    public static final int          ENTITY_TYPE_MEDIA_FOLDER              = 63;

    // --------- Log module entity types.-------------------

    /**
     * Project level constant for the type ViewProfile.
     */
    public static final int          ENTITY_TYPE_LOG_AUDIT_LOG_ENTRY       = 141;

    /**
     * Project level constant for the type ViewProfileField.
     */
    public static final int          ENTITY_TYPE_LOG_AUDIT_LOG_ENTRY_DATUM = 142;

    /*
     * Decode Group Codes.
     */

    // ----- Export Filter constants ---------------------------
    public static final byte         FILTER_DATA_TYPE_BOOLEAN              = 0;

    public static final byte         FILTER_DATA_TYPE_STRING               = 1;

    public static final byte         FILTER_DATA_TYPE_DATE                 = 2;

    public static final byte         FILTER_DATA_TYPE_INTEGER              = 3;

    public static final byte         FILTER_DATA_TYPE_CUSTOM               = 4;

    public static final byte         FILTER_DATA_TYPE_COUNT                = 5;

    // ------------------ Media File Constants--------------------------//

    /**
     * The path of the uploaded images are to be stored
     */
    public static final String       MEDIA_UPLOAD_PARENT_DIRECTORY         = "/WEB-INF/data/media";

    /**
     * The uploaded image width to be store
     */
    public static final int          THUMB_WIDTH                           = 160;

    /**
     * The uploaded image height to be store
     */
    public static final int          THUMB_HEIGHT                          = 48;

    /**
     * constant to specify the thumb ratio
     */
    public static final double       THUMB_RATIO                           = 0.733333333333d;

    // --- Media Types constants

    /**
     * Media Type image
     */
    public static final byte         MEDIA_FILE_TYPE_IMAGE                 = 0;

    /**
     * Media Type Thumb image
     */
    public static final byte         MEDIA_FILE_TYPE_THUMB                 = 1;

    /**
     * Media Type File
     */
    public static final byte         MEDIA_FILE_TYPE_FILE                  = 2;

    /**
     * Total Media types.
     */
    public static final byte         MEDIA_FILE_TYPE_COUNT                 = 3;

    // ------------------------------- Search Constants-----------------------------//
    /**
     * search indexes.
     */
    public static final String       SEARCH_INDEXES                        = "searchIndexes";

    /**
     * contact search indexe.
     */
    public static final String       SEARCH_INDEX_CONTACT                  = "contact";

    /**
     * address search indexe.
     */
    public static final String       SEARCH_INDEX_ADDRESS                  = "address";

    // Search filter properties
    public static final String       SEARCH_FILTER_OWNER_TYPE_ID           = "ownerTypeIdStr";

    /**
     * constant to specify the secrach fiels address
     */
    public static final String[]     SEARCH_FIELDS_ADDRESS                 = {};

    // --------------Category Tree edit types---------------------------
    public static final byte         TREE_NODE_INSERT                      = 0;

    public static final byte         TREE_NODE_UPDATE                      = 1;

    public static final byte         TREE_NODE_MOVE                        = 2;

    public static final byte         TREE_NODE_DELETE                      = 3;

    public static final String       ATTR_CAT_TREE_DOC                     = "c.tree_doc";

    public static final String       ATTR_USER_CAT_TREE_DOC                = "c.user.tree_doc";

    public static final String       ATTR_USER_BLOG_CAT_JSON               = "c.user.blog.json";

    public static final String       ATTR_USER_CONTACT_CAT_JSON            = "c.user.contact.json";

    public static final String       ATTR_USER_CONTACT_GROUPS              = "user_contact_groups";

    /*
     * Returned result for DWR.
     */
    public static final String       DWR_RESULT_SUCCESS                    = "success";

    public static final String       DWR_RESULT_ERROR                      = "error";

    public static final int          NUM_UNIQUE_CODE_CHARS_SIZE            = 36;

    public static final String       NUM_UNIQUE_CODE_CHARS                 = "abcdefghijklmonpqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    /*
     * MediaRepository Root folder name.
     */
    public static final String       REPOSITORY_ROOT_FOLDER                = "Root Folder";

    
    public static final List<String> GENDER;
    static {
        GENDER = new ArrayList<String>(2);
        GENDER.add("Male");
        GENDER.add("Female");
    }

}
