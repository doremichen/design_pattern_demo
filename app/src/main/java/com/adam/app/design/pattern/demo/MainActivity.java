/**
 * Description: This is the main activity of the application.
 * Author: Adam Chen
 * Date: 2025/07/02
 */
package com.adam.app.design.pattern.demo;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.adam.app.design.pattern.demo.databinding.ActivityMainBinding;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MainActivity extends AppCompatActivity {

    // view binding
    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // view binding
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        // set title
        setTitle(R.string.title_activity_main);

        // set adapter by item content list
        List<ItemContent> itemContentList = parseItemData();
        mBinding.listView.setAdapter(new MainListAdapter(this, itemContentList));

        // set empty view
        mBinding.listView.setEmptyView(mBinding.empty);

        // set listener
        mBinding.listView.setOnItemClickListener((parent, view, position, id) -> {

            ItemContent item = itemContentList.get(position);
            // show toast message
            Util.toast(this, item.getTitle());
            // start activity according to the item
            Intent intent = new Intent(); // Rename 'it' to 'intent' for clarity
            intent.setClassName(item.getPkgName(), item.getClassName());
            startActivity(intent);
        });

    }

    private interface XmlKeys {
        String NODE_DATA = "data";
        String ATTR_TITLE_RES = "titleRes";
        String ATTR_CLASS_NAME = "clsname";
        String ATTR_PACKAGE_NAME = "pkgname";
    }

    /**
     * This method reads an XML file ("itemData.xml") from the assets folder,
     * parses it using a DOM parser, extracts relevant attributes
     * from elements tagged "data", creates ItemContent objects representing
     * this data
     * @return a list of these objects or null if the some exception is occurred.
     */
    private List<ItemContent> parseItemData() {
        try (InputStream iStream = getResources().getAssets().open("itemDataRes.xml")) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(iStream);

            Element root = document.getDocumentElement();
            NodeList nodes = root.getElementsByTagName(XmlKeys.NODE_DATA);

            Resources res = getResources();
            Map<String, Integer> titleResMap = buildTitleResMap();

            return IntStream.range(0, nodes.getLength())
                    .mapToObj(nodes::item)
                    .filter(node -> node.getNodeType() == Node.ELEMENT_NODE)
                    .map(node -> (Element) node)
                    .map(itemData -> {
                        String titleResKey = itemData.getAttribute(XmlKeys.ATTR_TITLE_RES);
                        int titleResId = titleResMap.getOrDefault(titleResKey, 0);
                        String localizedTitle = titleResId != 0 ? res.getString(titleResId) : titleResKey;

                        return new ItemContent(
                                localizedTitle,
                                itemData.getAttribute(XmlKeys.ATTR_CLASS_NAME),
                                itemData.getAttribute(XmlKeys.ATTR_PACKAGE_NAME)
                        );
                    })
                    .collect(Collectors.toList());

        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
            // show toast message
            Util.toast(this, getString(R.string.toast_error_occurred_while_parsing_itemdata_xml));
            return Collections.emptyList(); // return empty list if error occurred
        }
    }



    private static Map<String, Integer> buildTitleResMap() {
        Map<String, Integer> map = new HashMap<>();
        try {
            // Use reflection to get all the fields in R.string
            Field[] fields = R.string.class.getFields();
            for (Field field : fields) {
                String name = field.getName();
                if (name.startsWith("title_demo_")) {
                    int resId = field.getInt(null); // use null in static field
                    map.put(name, resId);
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return map;
    }
}