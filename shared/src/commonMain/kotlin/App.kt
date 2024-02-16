import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import demo.DATA_SCHEMA
import demo.UI_SCHEMA
import demo.VALUES
import digital.steva.formumat.redux.Dispatcher
import digital.steva.formumat.redux.FormumatState
import digital.steva.formumat.redux.FormumatValues
import digital.steva.formumat.redux.createFormumatStore
import digital.steva.formumat.ui.FormView
import digital.steva.formumat.ui.PageNavigationView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun AppView() {
    val formumatStore = createFormumatStore(DATA_SCHEMA, UI_SCHEMA, VALUES)
    val coroutineScope = rememberCoroutineScope()
    val store by remember { mutableStateOf(formumatStore) }
    var state by remember { mutableStateOf(store.state) }
    DisposableEffect(store) {
        val unsubscribe = store.subscribe { state = store.state }
        onDispose { unsubscribe() }
    }
    val dispatch: Dispatcher = { store.dispatch(it) }
    val drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    BoxWithConstraints() {
        if (constraints.maxWidth >= 1200) {
            Scaffold(
                topBar = { Header(state.uiSchema.title ?: "Formumat", drawerState) },
            ) { paddingValues ->
                Row {
                    Column(
                        modifier = Modifier.width(IntrinsicSize.Max).widthIn(0.dp, 960.dp)
                    ) {
                        ModalDrawerSheet(
                        ) {
                            DrawerContent(state, dispatch, coroutineScope, drawerState)
                        }
                    }
                    MainView(state, dispatch, paddingValues)
                }
            }
        } else {
            ModalNavigationDrawer(
                drawerState = drawerState,
                drawerContent = {
                    ModalDrawerSheet(
                    ) {
                        DrawerContent(state, dispatch, coroutineScope, drawerState)
                    }
                }
            ) {
                Scaffold(
                    topBar = { Header(state.uiSchema.title ?: "Formumat", drawerState) },
                ) { paddingValues ->
                    MainView(state, dispatch, paddingValues)
                }
            }
        }
    }
}

@Composable
fun DrawerContent(
    formumatState: FormumatState,
    dispatch: Dispatcher,
    coroutineScope: CoroutineScope,
    drawerState: DrawerState
) {
    val values =
        FormumatValues(formumatState.data, formumatState.dataSchema.typesByKey, formumatState.uiSchema.fieldsByKey, dispatch)

    Column(
        modifier = Modifier.verticalScroll(rememberScrollState()).padding(top = 8.dp, bottom = 8.dp)
    ) {
        PageNavigationView(
            formumatState.uiSchema.items,
            formumatState.dataSchema.typesByKey,
            values,
            formumatState.currentPage,
            dispatch
        ) { coroutineScope.launch { drawerState.close() } }
    }
}

@Composable
fun MainView(
    state: FormumatState,
    dispatch: Dispatcher,
    paddingValues: PaddingValues
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues = paddingValues),
        verticalArrangement = Arrangement.Top
    ) {
        Box(modifier = Modifier.padding(8.dp)) {
            FormView(state.uiSchema, state.dataSchema, state, dispatch)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Header(title: String, drawerState: DrawerState) {
    val coroutineScope = rememberCoroutineScope()
    TopAppBar(
        title = {
            Text(title)
        },
        actions = {
            IconButton(
                onClick = { coroutineScope.launch { drawerState.open() } }
            ) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = ""
                )
            }
        }
    )
}
